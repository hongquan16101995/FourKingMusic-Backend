package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.Users;

import java.util.ArrayList;

public interface UserService {
    ArrayList<Users> findAll();

    void updateUser(Users user);

    Users findOne(Long id);

    Users findByUsername(String name);

    boolean checkPassword(Users user, String password);
}
