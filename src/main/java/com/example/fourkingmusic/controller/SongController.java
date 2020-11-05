package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@Controller
@CrossOrigin("*")
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public ResponseEntity<Iterable<Song>> getAllSong(){
        ArrayList<Song> songs = songService.findAll();
        ArrayList<Song> songArrayList = new ArrayList<>();
        int count = 0;
        for (Song song : songs) {
            songArrayList.add(song);
            count++;
            if (count == 7) {
                break;
            }
        }
        return new ResponseEntity<>(songArrayList, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<Iterable<Song>> getAllSongOfUser(@RequestBody Users user){
        Iterable<Song> songs = songService.findByUser(user);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Song>> getAllSongByName(@RequestBody String name){
        Iterable<Song> songs = songService.findByName(name);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/new")
    public ResponseEntity<Iterable<Song>> getAllPlaylistNew() {
        ArrayList<Song> songs = songService.findAll();
        ArrayList<Song> songArrayList = new ArrayList<>();
        int count = 0;
        for (int i = (songs.size()-1); i > 0; i--) {
            songArrayList.add(songs.get(i));
            count++;
            if (count == 10) {
                break;
            }
        }
        return new ResponseEntity<>(songArrayList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable("id") Long id){
        Song song = songService.findOne(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

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
