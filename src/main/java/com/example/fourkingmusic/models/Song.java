package com.example.fourkingmusic.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Vui lòng nhập tên bài hát!")
    @Size(max= 100, message = "Vui lòng nhập đúng tên bài hát1")
    private String name;

    private String description;

    @Size(max = 50, message = "Vui lòng không spam!")
    private String tags;
    private String avatarUrl;
    private String fileUrl;
    private Date dateCreated;
    private Long countLike = 0L;

    @ManyToOne
    @JoinColumn(name = "users")
    private Users user;

    @ManyToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "singer_song",
            joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = {@JoinColumn(name = "singer_id")})
    @JsonIgnoreProperties("songs")
    private Set<Singer> singers;

    @ManyToMany
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JoinTable(name = "playlist_song",
            joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = {@JoinColumn(name = "playlist_id")})
    @JsonIgnoreProperties("songs")
    private Set<Playlist> playlists;
}
