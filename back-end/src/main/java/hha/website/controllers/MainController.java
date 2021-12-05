package hha.website.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.security.config.annotation.authentication.configurers.userdetails.UserDetailsAwareConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @RequestMapping(value = "/api/mspp/submit", method = RequestMethod.POST)
    public ResponseEntity<?> saveData(@RequestHeader("Authorization") String jwt, @RequestBody String[] MSPPDataJson) {
        final User user = userDetailsService.findByUsername(jwtToken.extractUserName(jwt.substring(7)));
        try{
            return ResponseEntity.ok(msppRepositoryService.save(user, MSPPDataJson[0], MSPPDataJson[1]));
        } catch (IOException e){
            return new ResponseEntity<>("Failed to save data", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @RequestMapping(value = "/api/user/employeeofthemonth/submit", method = RequestMethod.POST)
    public ResponseEntity<?> updateEmployeeOfTheMonth(@RequestParam("userId") Integer userId, @RequestParam("month") String month) {
        return ResponseEntity.ok("User " + userDetailsService.setEmployeeOfTheMonth(userId, month) + " set as employee of the month for " + month);
    }

    @RequestMapping(value = "/api/user/employeeofthemonth", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployeeOfTheMonth(@RequestParam("month") String month) {
        return ResponseEntity.ok(userDetailsService.getEmployeeOfTheMonth(month));
    }

    @RequestMapping(value = "/api/user/allemployeesofthemonths", method = RequestMethod.GET)
    public ResponseEntity<?> getAllEmployeesOfTheMonths() {
        return ResponseEntity.ok(userDetailsService.getAllEmployeesOfTheMonths());
    }

    @GetMapping("/api/user/role")
    public ResponseEntity<?> getUserField() {
        return ResponseEntity.ok(userDetailsService.listDistinctItemsInField());
    }

    @GetMapping("/api/user/all")
    public ResponseEntity<?> getAllUsers(@RequestHeader("Authorization") String jwt) {
        final User user = userDetailsService.findByUsername(jwtToken.extractUserName(jwt.substring(7)));
        return ResponseEntity.ok(userDetailsService.listAllUsers(user).toArray());
    }

    @GetMapping("/api/departments")
    public ResponseEntity<?> getAllDepartments(){
        System.out.println(HHADepartmentService.listDepartmentNames());
        return ResponseEntity.ok(HHADepartmentService.listDepartmentNames());
    }

    @GetMapping("/api/mspp/{documentId}")
    public ResponseEntity<?> getADataForm(@PathVariable("documentId") String documentId){
        int id = Integer.parseInt(documentId);
        MSPPRequirement requiredData = msppRepositoryService.getAForm(id);
        System.out.println(HHADepartmentService.listDepartmentNames());
        return ResponseEntity.ok(requiredData);
    }

    @GetMapping("/api/msppadditional/{documentId}")
    public ResponseEntity<?> getAdditionalDataForm(@PathVariable("documentId") String documentId){
        int id = Integer.parseInt(documentId);
        AdditionalMSPP additionalData = msppRepositoryService.getAdditional(id);
        return ResponseEntity.ok(additionalData);
    }

    @GetMapping("/api/mspp/data/all")
    public ResponseEntity<?> getAllMSPPData(){
        System.out.println(msppRepositoryService.listMsppData());
        return ResponseEntity.ok(msppRepositoryService.listMsppData());
    }

    @DeleteMapping(value="/api/mspp/data/delete")
    public ResponseEntity<?> deleteMsppData(@RequestParam("id") Integer id) {
        try{
            msppRepositoryService.deleteForm(id);
            return new ResponseEntity<>("MSPP data entry has been deleted successfully", HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/casestudyinput", method = RequestMethod.POST)
    public ResponseEntity<?> saveCaseStudy(@RequestHeader("Authorization") String jwt, @RequestPart(value = "file", required = false) MultipartFile file, @RequestPart("data") String json) throws JsonProcessingException {
        final User user = userDetailsService.findByUsername(jwtToken.extractUserName(jwt.substring(7)));
        return ResponseEntity.ok(caseStudyService.save(user, json, file));
    }

    @GetMapping("/api/casestudy/types")
    public ResponseEntity<?> getCaseStudyTypes(){
        return ResponseEntity.ok(caseStudyService.listCaseStudyTypes());
    }

    @GetMapping("/api/casestudy/all")
    public ResponseEntity<?> getCaseStudyEntries(){
        return ResponseEntity.ok(caseStudyService.listAllCaseStudies());
    }

    @GetMapping("/api/casestudy/entry")
    public ResponseEntity<?> getCaseStudyEntry(@RequestParam("month") String month){
        return ResponseEntity.ok(caseStudyService.getACaseStudy(month));
    }

    @RequestMapping(value = "/api/casestudy/casestudyofthemonth/submit", method = RequestMethod.POST)
    public ResponseEntity<?> setCaseStudyOfTheMonth(@RequestParam("id") Integer id, @RequestParam("month") String month){
        return ResponseEntity.ok("Case study " + caseStudyService.setCaseStudyOfTheMonth(id, month) + " set as case study of the month for " + month);
    }

    @DeleteMapping(value="/api/casestudy/delete")
    public ResponseEntity<?> deleteCaseStudy(@RequestParam("id") Integer id) {
        try{
            caseStudyService.deleteCaseStudy(id);
            return new ResponseEntity<>("Case study has been deleted successfully", HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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
    public ResponseEntity<?> saveAnnouncement(@RequestHeader("Authorization") String jwt, @RequestPart(value = "monthlyPhoto", required = false) MultipartFile monthlyPhoto, @RequestPart("data") String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        AnnouncementDTO data = objectMapper.readValue(json, AnnouncementDTO.class);
        return ResponseEntity.ok(announcementService.save(data, monthlyPhoto));
    }

    @GetMapping("/api/announcements")
    public ResponseEntity<?> getLatestAnnouncements(@RequestParam("month") String month){
        return ResponseEntity.ok(announcementService.listMonthlyAnnouncements(month));
    }

    @DeleteMapping("/api/announcements/delete")
    public ResponseEntity<?> deleteAnnouncement(@RequestParam("id") Integer id){
        try{
            announcementService.deleteAnAnnouncement(id);
            return new ResponseEntity<>("Announcement has been deleted successfully", HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/api/messageboard/submit", method = RequestMethod.POST)
    public ResponseEntity<?> saveMessage(@RequestHeader("Authorization") String jwt, @RequestBody MessageBoardDTO data) {
        final User user = userDetailsService.findByUsername(jwtToken.extractUserName(jwt.substring(7)));
        return ResponseEntity.ok(messageBoardService.save(user, data));
    }

    @GetMapping("/api/messages")
    public ResponseEntity<?> getMessages(){
        return ResponseEntity.ok(messageBoardService.listAllMessages());
    }

    @DeleteMapping(value="/api/messages/delete")
    public ResponseEntity<?> deleteMessage(@RequestParam("id") Integer id) {
        try{
            messageBoardService.deleteMessage(id);
            return new ResponseEntity<>("Message has been deleted successfully", HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @DeleteMapping(value="/api/user/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        try{
            userDetailsService.deleteUser(id);
            return new ResponseEntity<>("user has been deleted successfully", HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}