package hha.website;

public class AuthenticationResponse {
    private final String jwt;

    public String getUsername() {
        return username;
    }

    private final String username;

    public AuthenticationResponse(String jwt, String username) {
        this.jwt = jwt;
        this.username = username;
    }

    public String getJwt() {
        return jwt;
    }
}
