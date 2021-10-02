package hha.website.controllers;

import hha.website.AuthenticationRequest;
import hha.website.AuthenticationResponse;
import hha.website.HHAUserDetailsService;
import hha.website.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MainController {

    /*
    main authorization process modified from: https://www.youtube.com/watch?v=X80nJ5T7YpE
     */




    /*
    @RequestMapping("/api/login")
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView loginPage(@RequestParam(value = "logout", required = false) String logout){
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }*/

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private HHAUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtToken;


    /*
    curl -i -H "Content-Type: application/json" -X POST -d '{"username": "user","password": "pass"}' localhost:8080/api/login
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

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }
}
