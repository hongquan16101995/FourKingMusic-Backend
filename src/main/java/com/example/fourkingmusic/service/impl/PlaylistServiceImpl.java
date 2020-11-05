package com.example.fourkingmusic.service.impl;

import com.example.fourkingmusic.models.Playlist;
import com.example.fourkingmusic.repository.PlaylistRepository;
import com.example.fourkingmusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public ArrayList<Playlist> findAll() {
        return (ArrayList<Playlist>) playlistRepository.findAll();
    }

    @Override
    public Iterable<Playlist> findByUser(Users user) {
        return playlistRepository.findAllByUser(user);
    }

    @Override
    public Iterable<Playlist> findByName(String name) {
        return playlistRepository.findAllByNameContaining(name);
    }

    @Override
    public Playlist findOne(Long id) {
        return playlistRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePlaylist(Long id) {
        playlistRepository.deleteById(id);
    }

    @Override
    public void savePlaylist(Playlist playlist) {
        playlistRepository.save(playlist);
    }
}
