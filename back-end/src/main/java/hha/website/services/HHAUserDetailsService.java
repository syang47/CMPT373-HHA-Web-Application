package hha.website.services;

import hha.website.MSPPRepository;
import hha.website.UserRepository;
import hha.website.models.User;
import hha.website.models.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class HHAUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) {

        User admin = new User();
        admin.setId(1);
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRole("ROLE_ADMIN");
        userRepository.save(admin);

        User randomHead = new User();
        randomHead.setId(2);
        randomHead.setUsername("head");
        randomHead.setPassword(passwordEncoder.encode("head"));
        randomHead.setRole("ROLE_HEAD");
        userRepository.save(randomHead);

        User randomUser = new User();
        randomUser.setId(3);
        randomUser.setUsername("user");
        randomUser.setPassword(passwordEncoder.encode("user"));
        randomUser.setRole("ROLE_USER");
        userRepository.save(randomUser);

        User user = userRepository.findByUsername(username);
        List<SimpleGrantedAuthority> roles;
        if(user != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), roles);
        }
        return null;
    }

    public User save(UserDTO user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole(user.getRole());
        return userRepository.save(newUser);
    }

    public Collection<String> listDistinctItemsInField() {
        return userRepository.queryDistinctField();
    }

}
