package com.example.fourkingmusic.service.impl;

import com.example.fourkingmusic.models.CommentSong;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.repository.CommentSongRepository;
import com.example.fourkingmusic.service.CommentSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentSongServiceImpl implements CommentSongService {
    @Autowired
    private CommentSongRepository commentSongRepository;

    @Override
    public Iterable<CommentSong> findAll() {
        return commentSongRepository.findAll();
    }

    @Override
    public CommentSong findOne(Long id) {
        return commentSongRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<CommentSong> findAllBySong(Song song) {
        return commentSongRepository.findAllBySong(song);
    }

    @Override
    public void saveCommentSong(CommentSong commentSong) {
        commentSongRepository.save(commentSong);
    }
}
