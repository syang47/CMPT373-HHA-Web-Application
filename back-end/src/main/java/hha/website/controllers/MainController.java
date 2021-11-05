package hha.website.controllers;

import hha.website.UserRepository;
import hha.website.auth.AuthenticationRequest;
import hha.website.auth.AuthenticationResponse;
import hha.website.services.*;
import hha.website.auth.JwtUtil;
import hha.website.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

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
    private HHADepartmentService HHADepartmentService;

    @Autowired
    private MSPPRepositoryService msppRepositoryService;

    @Autowired
    private AdditionalMSPPRepositoryService additionalMSPPRepositoryService;

    @Autowired
    private CaseStudyService caseStudyService;

    @Autowired
    private JwtUtil jwtToken;

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

        return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities(), u.getDepartments().getDepartmentname()));
    }

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        final String role = user.getRole().trim().toLowerCase();
        if(role.contains("admin")){
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
    public ResponseEntity<?> saveData(HttpServletRequest request, @RequestBody MSPPRequirementDTO data) {
        final String authorizationHeader = request.getHeader("Authorization");
        final String username = jwtToken.extractUserName(authorizationHeader.substring(7));
        final User user = userDetailsService.findByUsername(username);
        return ResponseEntity.ok(msppRepositoryService.save(user, data));
    }

    @RequestMapping(value = "/api/casestudyinput", method = RequestMethod.POST)
    public ResponseEntity<?> saveData(HttpServletRequest request, @RequestBody CaseStudyDTO data) {
        final String authorizationHeader = request.getHeader("Authorization");
        final String username = jwtToken.extractUserName(authorizationHeader.substring(7));
        final User user = userDetailsService.findByUsername(username);
        return ResponseEntity.ok(caseStudyService.save(user, data));
    }

    @GetMapping("/api/user/role")
    public ResponseEntity<?> getUserField() {
        System.out.println(Arrays.toString(userDetailsService.listDistinctItemsInField().toArray()));
        return ResponseEntity.ok(userDetailsService.listDistinctItemsInField());
    }


    @GetMapping("/api/departments")
    public ResponseEntity<?> getDepartments(){
        System.out.println(Arrays.toString(HHADepartmentService.listDepartmentNames().toArray()));
        return ResponseEntity.ok(HHADepartmentService.listDepartmentNames());
    }

    @GetMapping("/api/mspp/data")
    public ResponseEntity<?> getAllMSPPData(){
        return ResponseEntity.ok(msppRepositoryService.listAllData());
    }

    @GetMapping("/api/departments/nicu_users")
    public ResponseEntity<?> getNICUUsers(){
        return ResponseEntity.ok(HHADepartmentService.listUsersInNICU());
    }

    @GetMapping("/api/mspp/{documentId}")
    public ResponseEntity<?> getADataForm(@PathVariable("documentId") Integer documentId){
        MSPPRequirement requiredData = msppRepositoryService.getAForm(documentId);
        AdditionalMSPP additionalData = additionalMSPPRepositoryService.getAdditionalData(requiredData);

        HashMap<String, Object> result = new HashMap<>();
        result.put("main required data: ", requiredData);
        result.put("additional data: ", additionalData);

        return ResponseEntity.ok(result);
    }
}
