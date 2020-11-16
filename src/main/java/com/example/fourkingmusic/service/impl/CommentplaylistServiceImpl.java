package com.example.fourkingmusic.service.impl;

import com.example.fourkingmusic.models.Commentplaylist;
import com.example.fourkingmusic.models.Playlist;
import com.example.fourkingmusic.repository.CommentplaylistRepository;
import com.example.fourkingmusic.service.CommentplaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentplaylistServiceImpl implements CommentplaylistService {
    @Autowired
    private CommentplaylistRepository commentplaylistRepository;

    @Override
    public Iterable<Commentplaylist> findAllByPlaylist(Playlist playlist) {
        return commentplaylistRepository.findAllByPlaylist(playlist);
    }

    @Override
    public void saveCommentplaylist(Commentplaylist commentplaylist) {
        commentplaylistRepository.save(commentplaylist);
    }
}
