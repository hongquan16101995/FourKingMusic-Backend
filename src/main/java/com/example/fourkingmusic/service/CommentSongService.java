package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.CommentSong;
import com.example.fourkingmusic.models.Song;

public interface CommentSongService {
    Iterable<CommentSong> findAll();

    CommentSong findOne(Long id);

    Iterable<CommentSong> findAllBySong(Song song);

    void saveCommentSong(CommentSong commentSong);
}
