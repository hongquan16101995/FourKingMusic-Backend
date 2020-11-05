package com.example.fourkingmusic.service.impl;

import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.models.Users;
import com.example.fourkingmusic.repository.SongRepository;
import com.example.fourkingmusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Iterable<Song> findByName(String name) {
        return songRepository.findAllByNameContaining(name);
    }

    @Override
    public Iterable<Song> findByUser(Users user) {
        return songRepository.findAllByUser(user);
    }

    @Override
    public Song findOne(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    @Override
    public void saveSong(Song song) {
        songRepository.save(song);
    }
}
