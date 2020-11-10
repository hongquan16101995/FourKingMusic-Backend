package com.example.fourkingmusic.response;

import com.example.fourkingmusic.models.Users;

import java.util.List;

public class JwtResponse {
    private String token;
    private Long id;
    private Users user;

    public JwtResponse(String token, Long id, Users user) {
        this.token = token;
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
