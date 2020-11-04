package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.Song;

public interface SongService {
    Iterable<Song> findAll();

    Iterable<Song> findByName(String name);

    Iterable<Song> findByUser(Users user);

    Song findOne(Long id);

    void deleteSong(Long id);

    void saveSong(Song song);
}
