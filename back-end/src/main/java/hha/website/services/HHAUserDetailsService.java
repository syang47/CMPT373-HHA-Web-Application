package hha.website.services;

import hha.website.UserRepository;
import hha.website.models.Department;
import hha.website.models.User;
import hha.website.models.UserDTO;
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
        userDepartment.ifPresent(newUser::setDepartments);
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
        userRepository.save(admin);

        User randomHead = new User();
        randomHead.setId(2);
        randomHead.setUsername("head");
        randomHead.setPassword(passwordEncoder.encode("head"));
        randomHead.setRole("ROLE_HEAD");
        randomHead.setDepartments(HHADepartmentService.loadDepartmentByDepartmentName("NICU_PAED").get());
        userRepository.save(randomHead);

        User randomUser = new User();
        randomUser.setId(3);
        randomUser.setUsername("user");
        randomUser.setPassword(passwordEncoder.encode("user"));
        randomUser.setRole("ROLE_USER");
        randomUser.setDepartments(HHADepartmentService.loadDepartmentByDepartmentName("maternity").get());
        userRepository.save(randomUser);
    }

    public void addASubmittedReportForUser(User user) {
        userRepository.updateUserReportsSubmittedAdd(user.getId());
    }

    public void deleteASubmittedReportForUser(User user) {
        userRepository.updateUserReportsSubmittedSubtract(user.getId());
    }

    public List<List<String>> listAllUsers(User user) {
        List<List<String>> users = new ArrayList<>();
        List<User> userList;
        if(user.getRole().equals("ROLE_ADMIN") || user.getRole().equals("ROLE_HOSPITALADMIN")){
            userList = userRepository.findAll();
        } else {
            userList = userRepository.findByDepartmentId(user.getDepartment().getDepartmentname());
        }
        for(User u : userList){
            List<String> userData = new ArrayList<>();
            userData.add(u.getId().toString());
            userData.add(u.getUsername());
            userData.add(u.getDepartment().getDepartmentname());
            userData.add(u.getRole());
            users.add(userData);
        }
        return users;
    }

    public void deleteUser(Integer id) throws Exception {
        Optional<User> userToDelete = userRepository.findById(id);
        if(userToDelete.isPresent()){
            if(userToDelete.get().getRole().equals("ROLE_ADMIN") || userToDelete.get().getRole().equals("ROLE_HEAD") || userToDelete.get().getRole().equals("ROLE_HOSPITALADMIN")){
                throw new Exception("Cannot delete elevated user");
            } else {
                userRepository.deleteById(id);
            }
        }

    }

    public String setEmployeeOfTheMonth(Integer userId, String month){
        Optional<User> currentEmployeeOfTheMonth = userRepository.findByEmployeeOfTheMonth(month);
        currentEmployeeOfTheMonth.ifPresent(e -> e.setEmployeeOfTheMonth(""));
        User u = userRepository.getById(userId);
        u.setEmployeeOfTheMonth(month);
        return u.getUsername();
    }

    public List<String> getEmployeeOfTheMonth(String month) {
        List<String> employeeInfo = new ArrayList<>();
        Optional<User> u = userRepository.findByEmployeeOfTheMonth(month);
        u.ifPresent(e -> {
            employeeInfo.add(e.getUsername());
            employeeInfo.add(e.getDepartment().getDepartmentname());
            employeeInfo.add(e.getEmployeeOfTheMonth());
        });

        return employeeInfo;
    }

    public List<List<String>> getAllEmployeesOfTheMonths() {
        List<List<String>> users = new ArrayList<>();
        for(User u : userRepository.queryAllEmployeesOfTheMonths()){
            List<String> userData = new ArrayList<>();
            userData.add(u.getUsername());
            userData.add(u.getDepartment().getDepartmentname());
            userData.add(u.getEmployeeOfTheMonth());
            users.add(userData);
        }
        return users;
    }
}
