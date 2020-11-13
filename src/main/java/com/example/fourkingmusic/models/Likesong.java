package com.example.fourkingmusic.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Likesong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean status = false;

    @ManyToOne
    @JoinColumn(name = "user")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "song")
    private Song song;
}
