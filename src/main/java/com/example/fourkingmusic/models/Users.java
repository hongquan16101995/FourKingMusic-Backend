package com.example.fourkingmusic.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String gender;
    private String hobbies;
    private String avatarUrl;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
}
