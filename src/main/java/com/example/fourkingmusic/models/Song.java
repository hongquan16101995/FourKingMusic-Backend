package com.example.fourkingmusic.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    @ManyToMany(mappedBy = "songs")
    @EqualsAndHashCode.Exclude
    @JsonIgnoreProperties("songs")
    private Set<Singer> singers;
}
