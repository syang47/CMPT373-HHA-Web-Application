package hha.website.controllers;

import hha.website.UserRepository;
import hha.website.auth.AuthenticationRequest;
import hha.website.auth.AuthenticationResponse;
import hha.website.services.HHAUserDetailsService;
import hha.website.auth.JwtUtil;
import hha.website.models.*;
import hha.website.services.MSPPRepositoryService;
import hha.website.CaseStudyRepository;
import hha.website.models.CaseStudy;
import hha.website.services.CaseStudyService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.Collection;

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
    private UserRepository userRepository;

    @Autowired
    private MSPPRepositoryService msppRepositoryService;

    @Autowired
    private JwtUtil jwtToken;

    @Autowired
    private CaseStudyService caseStudyRepositoryService;

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

        final User u = userRepository.findByUsername(authenticationRequest.getUsername());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtToken.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities(), u.getDepartment()));
    }

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
            System.out.println("user registered: " +  user.getUsername() + " " + user.getPassword() + " " + user.getRole() + " " + user.getDepartment());
            return ResponseEntity.ok(userDetailsService.save(user));
        }
    }

    @RequestMapping(value = "/api/datainput", method = RequestMethod.POST)
    public ResponseEntity<?> saveData(@RequestBody MSPPRequirementDTO entry){
        return ResponseEntity.ok(msppRepositoryService.save(entry));
    }

    @GetMapping("/api/user/role")
    public ResponseEntity<?> getUserField() {
        System.out.println(Arrays.toString(userDetailsService.listDistinctItemsInField().toArray()));
        return ResponseEntity.ok(userDetailsService.listDistinctItemsInField());
    }

    @RequestMapping(value = "/api/casestudy", method = RequestMethod.POST)
    public ResponseEntity<?> getCaseStudyField(@RequestBody CaseStudyDTO entry) {
        System.out.println("entring case study");
        System.out.println("casestudy added: " +  entry.getTitle() + " " + entry.getDate() + " " + entry.getPoints() + " " + entry.getSubmissionStatus());
        return ResponseEntity.ok(caseStudyRepositoryService.save(entry));
    }

    @RequestMapping(value = "/api/casestudy", method = RequestMethod.GET)
    public ResponseEntity<?> getCaseStudyField() {
        caseStudyRepositoryService.loadCaseStudyByTitle();
        System.out.println("casestudycasestudy");
        System.out.println(Arrays.toString(caseStudyRepositoryService.listDistinctItemsInField().toArray()));
        return ResponseEntity.ok(caseStudyRepositoryService.listDistinctItemsInField());
        
    }

    @RequestMapping(value = "/api/casestudy/points", method = RequestMethod.GET)
    public ResponseEntity<?> getCaseStudyPointsField() {
        System.out.println("casestudypoints");
        System.out.println(Arrays.toString(caseStudyRepositoryService.listPointsInField().toArray()));
        return ResponseEntity.ok(caseStudyRepositoryService.listPointsInField());
        
    }
    @RequestMapping(value = "/api/casestudy/submissionstatus", method = RequestMethod.GET)
    public ResponseEntity<?> getCaseStudySubStatusField() {
        System.out.println("casestudysubmission status");
        System.out.println(Arrays.toString(caseStudyRepositoryService.listSubmissionStatusInField().toArray()));
        return ResponseEntity.ok(caseStudyRepositoryService.listSubmissionStatusInField());
        
    }

    @RequestMapping(value = "/api/casestudy/totalreports", method = RequestMethod.GET)
    public ResponseEntity<?> getCaseStudyTotReportField() {
        System.out.println("total casestudy submitted");
        System.out.println(Arrays.toString(caseStudyRepositoryService.listTotalReportsSubmittedField().toArray()));
        return ResponseEntity.ok(caseStudyRepositoryService.listTotalReportsSubmittedField());
        
    }
}
