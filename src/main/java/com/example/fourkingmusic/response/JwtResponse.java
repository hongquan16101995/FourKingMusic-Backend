package com.example.fourkingmusic.response;

import java.util.List;

public class JwtResponse {
    private String token;
//    private String type = "Bear";
    private String username;
    private String email;
    private List<String> roles;
    private String avatarUrl;
    private String gender;
    private String name;
    private String hobbies;

    public JwtResponse(String token, String username,
                       String email, List<String> roles, String avatarUrl,
                       String gender, String name, String hobbies) {
        this.token = token;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.avatarUrl = avatarUrl;
        this.gender = gender;
        this.name = name;
        this.hobbies = hobbies;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

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
