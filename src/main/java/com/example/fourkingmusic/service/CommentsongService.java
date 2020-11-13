package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.Commentsong;
import com.example.fourkingmusic.models.Song;

public interface CommentsongService {
    Iterable<Commentsong> findAllBySong(Song song);

    void saveComment(Commentsong commentsong);
}
