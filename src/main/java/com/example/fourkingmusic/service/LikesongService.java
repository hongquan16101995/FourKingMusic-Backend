package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.Likesong;
import com.example.fourkingmusic.models.Song;

public interface LikesongService {
    Iterable<Likesong> findAll();

    Iterable<Likesong> findAllBySong(Song song);

    Likesong findOne(Long id);

    void deleteLikesong(Long id);

    void saveLikesong(Likesong likesong);
}
