package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.Users;

public interface UserService {
    void updateUser(Users user);

    Users findOne(Long id);

    Users findByUsername(String name);

    boolean checkPassword(Users user, String password);
}
