package com.example.fourkingmusic.service.impl;

import com.example.fourkingmusic.models.Users;
import com.example.fourkingmusic.repository.UserRepository;
import com.example.fourkingmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ArrayList<Users> findAll() {
        return (ArrayList<Users>) userRepository.findAll();
    }

    @Override
    public void updateUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public Users findOne(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Users findByUsername(String name) {
        return userRepository.findByUsername(name);
    }

    @Override
    public boolean checkPassword(Users user, String password) {
        return passwordEncoder.matches(password, user.getPassword());
    }
}
