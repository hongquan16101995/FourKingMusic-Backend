package com.example.fourkingmusic.service.impl;

import com.example.fourkingmusic.models.Commentsong;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.repository.CommentsongRepository;
import com.example.fourkingmusic.service.CommentsongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsongServiceImpl implements CommentsongService {
    @Autowired
    private CommentsongRepository commentsongRepository;

    @Override
    public Iterable<Commentsong> findAllBySong(Song song) {
        return commentsongRepository.findAllBySong(song);
    }

    @Override
    public void saveComment(Commentsong commentsong) {
        commentsongRepository.save(commentsong);
    }
}
