package com.example.fourkingmusic.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String tags;
    private String avatarUrl;
    private String fileUrl;
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "users")
    private Users user;

    @ManyToMany
    @JoinTable(name = "playlist_song",
            joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = {@JoinColumn(name = "playlist_id")})
    private Set<Playlist> playlists;

    @ManyToMany
    @JoinTable(name = "singer_song",
            joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = {@JoinColumn(name = "singer_id")})
    private Set<Singer> singers;
}
