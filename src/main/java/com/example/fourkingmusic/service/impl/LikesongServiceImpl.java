package com.example.fourkingmusic.service.impl;

import com.example.fourkingmusic.models.Likesong;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.repository.LikesongRepository;
import com.example.fourkingmusic.service.LikesongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesongServiceImpl implements LikesongService {
    @Autowired
    private LikesongRepository likesongRepository;

    @Override
    public Iterable<Likesong> findAll() {
        return likesongRepository.findAll();
    }

    @Override
    public Iterable<Likesong> findAllBySong(Song song) {
        return likesongRepository.findAllBySong(song);
    }

    @Override
    public Likesong findOne(Long id) {
        return likesongRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteLikesong(Long id) {
        likesongRepository.deleteById(id);
    }

    @Override
    public void saveLikesong(Likesong likesong) {
        likesongRepository.save(likesong);
    }
}
