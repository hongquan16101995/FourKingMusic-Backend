package com.example.fourkingmusic.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "commentsong")
public class CommentSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "songId")
    private Song song;

}
