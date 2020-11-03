package com.example.fourkingmusic.model;

import lombok.Data;
import org.hibernate.annotations.Entity;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;

@Entity
@Data
public class User {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "interests")
    private String iterests;
}
