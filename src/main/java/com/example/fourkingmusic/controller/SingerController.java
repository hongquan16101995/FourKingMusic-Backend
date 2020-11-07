package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Singer;
import com.example.fourkingmusic.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;

    @PostMapping
    public ResponseEntity<Singer> createSinger(@RequestBody Singer singer){
        singerService.saveSinger(singer);
        return new ResponseEntity<>(singer, HttpStatus.OK);
    }
}
