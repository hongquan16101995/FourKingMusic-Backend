package com.example.fourkingmusic.response;

import com.example.fourkingmusic.models.Users;

import java.util.List;

public class JwtResponse {
    private String token;
    private String username;
    private String email;
    private List<String> roles;
    private Users user;

    public JwtResponse(String token, String username,
                       String email, List<String> roles, Users user) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
