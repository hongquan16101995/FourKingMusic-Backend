package com.example.fourkingmusic.service.impl;

import com.example.fourkingmusic.models.Likeplaylist;
import com.example.fourkingmusic.models.Playlist;
import com.example.fourkingmusic.repository.LikeplaylistRepository;
import com.example.fourkingmusic.service.LikeplaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeplaylistServiceImpl implements LikeplaylistService {
    @Autowired
    private LikeplaylistRepository likeplaylistRepository;

    @Override
    public Iterable<Likeplaylist> findAll() {
        return likeplaylistRepository.findAll();
    }

    @Override
    public Iterable<Likeplaylist> findAllByPlaylist(Playlist playlist) {
        return likeplaylistRepository.findAllByPlaylist(playlist);
    }

    @Override
    public Likeplaylist findOne(Long id) {
        return likeplaylistRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteLikeplaylist(Long id) {
        likeplaylistRepository.deleteById(id);
    }

    @Override
    public void saveLikeplaylist(Likeplaylist likeplaylist) {
        likeplaylistRepository.save(likeplaylist);
    }
}
