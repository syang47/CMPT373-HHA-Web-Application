package hha.website.auth;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthenticationResponse {
    private final String jwt;
    private final String username;
    Collection<? extends GrantedAuthority> roles;
    private final String department;

    public AuthenticationResponse(String jwt, String username, Collection<? extends GrantedAuthority> roles, String department) {
        this.jwt = jwt;
        this.username = username;
        this.roles = roles;
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public String getJwt() {
        return jwt;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public String getDepartment() {
        return department;
    }
}
