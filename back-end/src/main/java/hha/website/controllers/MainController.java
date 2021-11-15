package hha.website.controllers;

import hha.website.UserRepository;
import hha.website.auth.AuthenticationRequest;
import hha.website.auth.AuthenticationResponse;
import hha.website.services.*;
import hha.website.auth.JwtUtil;
import hha.website.models.*;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


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
    private AnnouncementService announcementService;

    @Autowired
    private MessageBoardService messageBoardService;

    @Autowired
    private JwtUtil jwtToken;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }

        final User u = userRepository.findByUsername(authenticationRequest.getUsername());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtToken.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities(), u.getDepartment().getDepartmentname()));
    }

    @CrossOrigin
    @RequestMapping(value = "/api/checktoken", method = RequestMethod.GET)
    public ResponseEntity<?> checkToken(@RequestHeader("Authorization") String jwt) throws Exception {
        try {
            final String tok = jwt.substring(7);
            final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtToken.extractUserName(tok));
            if(jwtToken.validateToken(tok, userDetails)){
                return ResponseEntity.accepted().body("Token is valid.");
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        }
    }

    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) {
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        final String role = user.getRole().trim().toLowerCase();
        if(role.contains("admin")){
            return ResponseEntity.badRequest().body("Cannot make admin account");
        } else if(userDetails != null){
            return ResponseEntity.badRequest().body("User already exists.");
        } else {
            System.out.println("user registered: " +  user.getUsername() + " " + user.getPassword() + " " + user.getRole() + " " + user.getDepartment());
            return ResponseEntity.ok(userDetailsService.save(user));
        }
    }

    @RequestMapping(value = "/api/datainput", method = RequestMethod.POST)
    public ResponseEntity<?> saveData(@RequestHeader("Authorization") String jwt, @RequestBody MSPPRequirementDTO data) {
        final User user = userDetailsService.findByUsername(jwtToken.extractUserName(jwt.substring(7)));
        return ResponseEntity.ok(msppRepositoryService.save(user, data));
    }

    @RequestMapping(value = "/api/casestudyinput", method = RequestMethod.POST)
    public ResponseEntity<?> saveCaseStudy(@RequestHeader("Authorization") String jwt, @RequestBody CaseStudyDTO data) {
        final User user = userDetailsService.findByUsername(jwtToken.extractUserName(jwt.substring(7)));
        return ResponseEntity.ok(caseStudyService.save(user, data));
    }

    @CrossOrigin
    @GetMapping("/api/user/role")
    public ResponseEntity<?> getUserField() {
        System.out.println(Arrays.toString(userDetailsService.listDistinctItemsInField().toArray()));
        return ResponseEntity.ok(userDetailsService.listDistinctItemsInField());
    }

    @CrossOrigin
    @GetMapping("/api/departments")
    public ResponseEntity<?> getAllDepartments(){
        System.out.println(Arrays.toString(HHADepartmentService.listDepartmentNames().toArray()));
        return ResponseEntity.ok(HHADepartmentService.listDepartmentNames());
    }

    @CrossOrigin
    @GetMapping("/api/mspp/data")
    public ResponseEntity<?> getAllMSPPData(){
        return ResponseEntity.ok(msppRepositoryService.listAllData());
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

    @GetMapping("/api/mspp/data/{date}/{id}")
    public ResponseEntity<?> getMsppByFirstname(@PathVariable("id") String id, @PathVariable("date") String date) throws ParseException {
        LocalDate parsedDate = LocalDate.parse(date);
        int finalId = Integer.parseInt(id);
        System.out.println(parsedDate);
        return ResponseEntity.ok(msppRepositoryService.listByIdAndDate(finalId, parsedDate));
    }

    @CrossOrigin
    @GetMapping("/api/casestudy/types")
    public ResponseEntity<?> getCaseStudyTypes(){
        return ResponseEntity.ok(caseStudyService.listCaseStudyTypes());
    }

    @CrossOrigin
    @GetMapping("/api/casestudy/entry")
    public ResponseEntity<?> getCaseStudyEntry(){
        return ResponseEntity.ok(caseStudyService.listAllCaseStudies());
    }


    @RequestMapping(value = "/api/departments/totalreports", method = RequestMethod.GET)
    @GetMapping(value = "/api/departments/totalreports")
    public ResponseEntity<?> getTotalReportsSubmittedForDepartment(@RequestParam("department") String department) {
        System.out.println("total casestudy submitted for " +  department);
        System.out.println(HHADepartmentService.listTotalReportsSubmittedForDepartment(department));
        return ResponseEntity.ok(HHADepartmentService.listTotalReportsSubmittedForDepartment(department));
    }

    @GetMapping(value = "/api/departments/points")
    public ResponseEntity<?> getAllDepartmentPoints() {
        List<Department> departments = HHADepartmentService.listAllDepartments();
        HashMap<String, Integer> departmentPoints = new HashMap<>();
        for(Department d : departments){
            departmentPoints.put(d.getDepartmentname(), d.getPoints());
        }
        return ResponseEntity.ok(departmentPoints);
    }

    @RequestMapping(value = "/api/announcements/submit", method = RequestMethod.POST)
    public ResponseEntity<?> saveAnnouncement(@RequestHeader("Authorization") String jwt, @RequestBody AnnouncementDTO data) {
        final User user = userDetailsService.findByUsername(jwtToken.extractUserName(jwt.substring(7)));
        return ResponseEntity.ok(announcementService.save(data));
    }

    @CrossOrigin
    @GetMapping("/api/announcements")
    public ResponseEntity<?> getAnnouncements(@RequestParam("field") String field){
        return ResponseEntity.ok(announcementService.listAField(field));
    }


    @RequestMapping(value = "/api/messageboard/submit", method = RequestMethod.POST)
    public ResponseEntity<?> saveMessage(@RequestHeader("Authorization") String jwt, @RequestBody MessageBoardDTO data) {
        final User user = userDetailsService.findByUsername(jwtToken.extractUserName(jwt.substring(7)));
        return ResponseEntity.ok(messageBoardService.save(user, data));
    }

    @CrossOrigin
    @GetMapping("/api/messages")
    public ResponseEntity<?> getMessages(){
        return ResponseEntity.ok(messageBoardService.listAllMessages());
    }

}