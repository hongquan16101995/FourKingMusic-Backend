package com.example.fourkingmusic.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Commentsong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "user")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "song")
    private Song song;

}
