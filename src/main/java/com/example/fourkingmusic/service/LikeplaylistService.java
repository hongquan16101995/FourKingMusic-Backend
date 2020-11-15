package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.Likeplaylist;
import com.example.fourkingmusic.models.Playlist;

public interface LikeplaylistService {
    Iterable<Likeplaylist> findAll();

    Iterable<Likeplaylist> findAllByPlaylist(Playlist playlist);

    Likeplaylist findOne(Long id);

    void deleteLikeplaylist(Long id);

    void saveLikeplaylist(Likeplaylist likeplaylist);
}
