package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.CommentSong;

public interface CommentSongService {
    Iterable<CommentSong> findAll();

    CommentSong findOne(Long id);

    void saveCommentSong(CommentSong commentSong);
}
