package com.example.fourkingmusic.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private String avatarUrl;

    @ManyToMany
    @JoinTable(name = "singer_song",
            joinColumns = {@JoinColumn(name = "singer_id")},
            inverseJoinColumns = {@JoinColumn(name = "song_id")})
    private Set<Song> songs;
}
