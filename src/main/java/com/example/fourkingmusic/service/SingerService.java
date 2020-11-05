package com.example.fourkingmusic.service;

import com.example.fourkingmusic.models.Singer;

import java.util.ArrayList;

public interface SingerService {
    ArrayList<Singer> findAll();

    Iterable<Singer> findByName(String name);

    Singer findOne(Long id);

    void saveSinger(Singer singer);
}
