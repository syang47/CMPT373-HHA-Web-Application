package hha.website.controllers;

import hha.website.MSPPRepository;
import hha.website.auth.AuthenticationRequest;
import hha.website.auth.AuthenticationResponse;
import hha.website.services.HHAUserDetailsService;
import hha.website.auth.JwtUtil;
import hha.website.models.*;
import hha.website.services.MSPPRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

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
    private MSPPRepositoryService msppRepositoryService;

    @Autowired
    private JwtUtil jwtToken;

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
        return ResponseEntity.ok(new AuthenticationResponse(jwt, authenticationRequest.getUsername(), userDetails.getAuthorities()));
    }

    /*

    curl -i -H "Content-Type: application/json" -X POST -d '{"username": "admin","password": "admin","role": "ROLE_ADMIN"}' localhost:8080/api/register
     */

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        if (user.getRole().trim().toLowerCase().contains("admin")) {
            System.out.println("Cannot make admin account");
            return ResponseEntity.badRequest().body("Cannot make admin account");
        } else if (userDetails != null) {
            System.out.println("User already exists.");
            return ResponseEntity.badRequest().body("User already exists.");
        } else {
            System.out.println("user registered: " + user.getUsername() + " " + user.getPassword() + " " + user.getRole());
            return ResponseEntity.ok(userDetailsService.save(user));
        }
    }

    @RequestMapping(value = "/api/datainput", method = RequestMethod.POST)
    public ResponseEntity<?> getNICUPAEDData(@RequestBody MSPPRequirementDTO entry) {
        return ResponseEntity.ok(msppRepositoryService.save(entry));
    }

    @GetMapping("/datainput")
    public String datainputForm(Model model) {
        model.addAttribute("datainput", new DataInput());
        return "dataInput";
    }
    @PostMapping("/datainput")
    public String datainputSubmit(@ModelAttribute DataInput datainput, Model model) {
        model.addAttribute("datainput", datainput);
        Object result = model.getAttribute("datainput");
        return datainput.getMonthly() + datainput.getAnnual();
    }

    @GetMapping("/datainput/monthly")
    public String datainputSubmitMonthly(@ModelAttribute DataInput datainput, Model model) {
        model.addAttribute("datainput", datainput);
        Object result = model.getAttribute("datainput");
        return datainput.getMonthly();
    }
    @GetMapping("/datainput/annual")
    public String datainputSubmitAnnual(@ModelAttribute DataInput datainput, Model model) {
        model.addAttribute("datainput", datainput);
        Object result = model.getAttribute("datainput");
        return datainput.getAnnual();
    }
}