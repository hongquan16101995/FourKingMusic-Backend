package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.models.Users;
import com.example.fourkingmusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@CrossOrigin("*")
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song){
        song.setDateCreated(new Date());
        songService.saveSong(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Song> deleteSong(@PathVariable("id") Long id){
        songService.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Song> updateSong(@RequestBody Song song){
        songService.saveSong(song);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }
}
