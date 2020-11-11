package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.Likesong;

public interface LikesongService {
    Iterable<Likesong> findAll();

    Likesong findOne(Long id);

    void saveLikesong(Likesong likesong);
}
