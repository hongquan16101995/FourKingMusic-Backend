package com.example.fourkingmusic.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String avatarUrl;

    @ManyToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "singer_song",
            joinColumns = {@JoinColumn(name = "singer_id")},
            inverseJoinColumns = {@JoinColumn(name = "song_id")})
    @JsonIgnoreProperties("singers")
    private Set<Song> songs;
}
