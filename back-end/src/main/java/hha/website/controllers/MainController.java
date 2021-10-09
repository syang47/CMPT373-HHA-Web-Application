package hha.website.controllers;

import hha.website.AuthenticationRequest;
import hha.website.AuthenticationResponse;
import hha.website.HHAUserDetailsService;
import hha.website.UserRepository;
import hha.website.config.JwtUtil;
import hha.website.models.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@CrossOrigin
public class MainController {

    /*
    main authorization process modified from: https://www.youtube.com/watch?v=X80nJ5T7YpE
    https://www.javainuse.com/webseries/spring-security-jwt/chap5
    https://medium.com/@szczypka.m/spring-boot-and-spring-security-jwt-mysql-database-bfd2df928ab5
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private HHAUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtToken;

    private UserRepository userRepository;

    /*
    curl -i -H "Content-Type: application/json" -X POST -d '{"username": "admin","password": "admin"}' localhost:8080/api/login
     */
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println(authenticationRequest.getUsername());
        System.out.println(authenticationRequest.getPassword());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Wrong username/password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtToken.generateToken(userDetails);
        System.out.println(jwt);
        return ResponseEntity.ok(new AuthenticationResponse(jwt, authenticationRequest.getUsername()));
    }

    /*

    curl -i -H "Content-Type: application/json" -X POST -d '{"username": "admin","password": "admin","role": "ROLE_ADMIN"}' localhost:8080/api/register
     */

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        if(user.getRole().trim().toLowerCase().contains("admin")){
            System.out.println("Cannot make admin account");
            return ResponseEntity.badRequest().body("Cannot make admin account");
        } else if(userDetails != null){
            System.out.println("User already exists.");
            return ResponseEntity.badRequest().body("User already exists.");
        } else {
            System.out.println("user registered: " +  user.getUsername() + user.getPassword() + user.getRole());
            return ResponseEntity.ok(userDetailsService.save(user));
        }
    }

    /*
    get JWT from logging in with user account at /api/login then use
    curl -i -H "Authorization: Bearer **INSERT JWT HERE**" -X GET localhost:8080/user
    e.g. curl -i -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzQWRtaW4iOnRydWUsImV4cCI6MTYzMzQwOTIwNywiaWF0IjoxNjMzNDA1NjA3fQ.8dpK_-L6HpkKZrilSED5GjQKXi-px8s35ZAEgBhp_3g" -X GET localhost:8080/user
     */

    @GetMapping("/api/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String allAccess() {
        return "User Content.";
    }

    /*
    get JWT from logging in with admin account at /api/login then use
    curl -i -H "Authorization: Bearer **INSERT JWT HERE**" -X GET localhost:8080/admin
    e.g. curl -i -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzQWRtaW4iOnRydWUsImV4cCI6MTYzMzQwOTIwNywiaWF0IjoxNjMzNDA1NjA3fQ.8dpK_-L6HpkKZrilSED5GjQKXi-px8s35ZAEgBhp_3g" -X GET localhost:8080/admin
     */

    @GetMapping("/api/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String userAccess() {
        return "Admin Content.";
    }
}
