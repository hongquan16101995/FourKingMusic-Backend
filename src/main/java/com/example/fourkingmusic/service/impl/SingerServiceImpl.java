package com.example.fourkingmusic.service.impl;

import com.example.fourkingmusic.models.Singer;
import com.example.fourkingmusic.repository.SingerRepository;
import com.example.fourkingmusic.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerRepository singerRepository;

    @Override
    public ArrayList<Singer> findAll() {
        return (ArrayList<Singer>) singerRepository.findAll();
    }

    @Override
    public Iterable<Singer> findByName(String name) {
        return singerRepository.findAllByNameContaining(name);
    }

    @Override
    public Singer findOne(Long id) {
        return singerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSinger(Singer singer) {
        singerRepository.save(singer);
    }
}
