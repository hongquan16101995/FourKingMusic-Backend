package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.Commentplaylist;
import com.example.fourkingmusic.models.Playlist;

public interface CommentplaylistService {
    Iterable<Commentplaylist> findAllByPlaylist(Playlist playlist);

    void saveCommentplaylist(Commentplaylist commentplaylist);
}
