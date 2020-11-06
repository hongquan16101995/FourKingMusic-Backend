package com.example.fourkingmusic.response;

import com.example.fourkingmusic.models.Users;

import java.util.List;

public class JwtResponse {
    private String token;
    private String username;
    private Long id;
    private List<String> roles;
    private Users user;

    public JwtResponse(String token, String username,
                       Long id, List<String> roles, Users user) {
        this.token = token;
        this.username = username;
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
