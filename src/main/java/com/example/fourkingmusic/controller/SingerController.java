package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Singer;
import com.example.fourkingmusic.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@CrossOrigin("*")
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;

    @GetMapping
    public ResponseEntity<Iterable<Singer>> getAllSinger(){
        ArrayList<Singer> singers = singerService.findAll();
        ArrayList<Singer> singerArrayList = new ArrayList<>();
        int count = 0;
        for (Singer singer : singers) {
            singerArrayList.add(singer);
            count++;
            if (count == 7) {
                break;
            }
        }
        return new ResponseEntity<>(singerArrayList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Singer> getSingerById(@PathVariable("id") Long id){
        Singer singer = singerService.findOne(id);
        return new ResponseEntity<>(singer, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Singer>> getAllSingerByName(@RequestBody String name){
        Iterable<Singer> singers = singerService.findByName(name);
        return new ResponseEntity<>(singers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Singer> createSinger(@RequestBody Singer singer){
        singerService.saveSinger(singer);
        return new ResponseEntity<>(singer, HttpStatus.OK);
    }
}
