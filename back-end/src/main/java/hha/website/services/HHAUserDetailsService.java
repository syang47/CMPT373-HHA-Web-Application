package hha.website.services;

import hha.website.UserRepository;
import hha.website.models.Department;
import hha.website.models.User;
import hha.website.models.UserDTO;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
@DependsOn("HHADepartmentService")
public class HHAUserDetailsService implements UserDetailsService {

    @Autowired
    private HHADepartmentService HHADepartmentService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        List<SimpleGrantedAuthority> roles;
        if(user != null) {
            roles = Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
        }
        return null;
    }

    public User save(UserDTO user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        Optional<Department> userDepartment = HHADepartmentService.loadDepartmentByDepartmentName(user.getDepartment());
        userDepartment.ifPresent(d -> newUser.setDepartments(d));
        newUser.setPoints(0);
        return userRepository.save(newUser);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Collection<String> listDistinctItemsInField() {
        return userRepository.queryDistinctField();
    }

    @PostConstruct
    public void initializeUsers() {
        System.out.println("initalizing users...");

        User admin = new User();
        admin.setId(1);
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole("ROLE_ADMIN");
        admin.setDepartments(HHADepartmentService.loadDepartmentByDepartmentName("NICU_PAED").get());
        admin.setReportsSubmitted(0);
        admin.setPoints(0);
        userRepository.save(admin);

        User randomHead = new User();
        randomHead.setId(2);
        randomHead.setUsername("head");
        randomHead.setPassword(passwordEncoder.encode("head"));
        randomHead.setRole("ROLE_HEAD");
        randomHead.setDepartments(HHADepartmentService.loadDepartmentByDepartmentName("NICU_PAED").get());
        randomHead.setPoints(0);
        userRepository.save(randomHead);

        User randomUser = new User();
        randomUser.setId(3);
        randomUser.setUsername("user");
        randomUser.setPassword(passwordEncoder.encode("user"));
        randomUser.setRole("ROLE_USER");
        randomUser.setDepartments(HHADepartmentService.loadDepartmentByDepartmentName("maternity").get());
        randomUser.setPoints(0);
        userRepository.save(randomUser);
    }

    public void addASubmittedReportForUser(User user) {
        userRepository.updateUserReportsSubmitted(user.getId());
    }
    
    public List<List<String>> listAllUsers() {
        List<List<String>> users = new ArrayList<>();
        for(User u : userRepository.findAll()){
            List<String> userData = new ArrayList<>();
            userData.add(u.getId().toString());
            userData.add(u.getUsername());
            userData.add(u.getDepartment().getDepartmentname());
            userData.add(u.getRole());
            users.add(userData);
        }
        return users;
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
    // public List<String> listUsernames() {
    //     return userRepository.queryUsername();
    // }

    // private Session session;
    // public List<User> findAllUsers() {
    //     return Session.createQuery("SELECT a FROM User a", User.class).getResultList();
    // }
}
