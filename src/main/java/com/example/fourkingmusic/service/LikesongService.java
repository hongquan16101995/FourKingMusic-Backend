package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.Likesong;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.models.Users;

public interface LikesongService {
    Iterable<Likesong> findAll();

    Likesong findOne(Long id);

    Likesong findByUserAndSong(Users user, Song song);

    void saveLikesong(Likesong likesong);
}
