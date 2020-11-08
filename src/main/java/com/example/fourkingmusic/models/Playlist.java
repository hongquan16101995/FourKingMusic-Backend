package com.example.fourkingmusic.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Vui lòng nhập tên play list của bạn!")
    private String name;
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "user")
    private Users user;

    @ManyToMany
    @JoinTable(name = "playlist_song",
            joinColumns = {@JoinColumn(name = "playlist_id")},
            inverseJoinColumns = {@JoinColumn(name = "song_id")})
    private Set<Song> songs;
}
