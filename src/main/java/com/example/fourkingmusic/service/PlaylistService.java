package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.Playlist;
import com.example.fourkingmusic.models.Users;

import java.util.ArrayList;

public interface PlaylistService {
    ArrayList<Playlist> findAll();

    Iterable<Playlist> findByUser(Users user);

    Iterable<Playlist> findByName(String name);

    Playlist findOne(Long id);

    void deletePlaylist(Long id);

    void savePlaylist(Playlist playlist);
}
