package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.models.Users;

import java.util.ArrayList;

public interface SongService {
    ArrayList<Song> findAll();

    Iterable<Song> findByName(String name);

    Iterable<Song> findByUser(Users user);

    Song findOne(Long id);

    void deleteSong(Long id);

    void saveSong(Song song);
}
