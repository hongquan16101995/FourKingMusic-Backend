package com.example.fourkingmusic.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Likeplaylist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean status = false;

    @ManyToOne
    @JoinColumn(name = "user")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "playlist")
    private Playlist playlist;
}
