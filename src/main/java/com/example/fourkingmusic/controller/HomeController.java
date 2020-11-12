package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Playlist;
import com.example.fourkingmusic.models.Singer;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.response.MessageResponse;
import com.example.fourkingmusic.service.PlaylistService;
import com.example.fourkingmusic.service.SingerService;
import com.example.fourkingmusic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@CrossOrigin("*")
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private SongService songService;

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private SingerService singerService;

    @GetMapping("/singer")
    public ResponseEntity<Iterable<Singer>> getAllSinger(){
        ArrayList<Singer> singers = singerService.findAll();
        return new ResponseEntity<>(singers, HttpStatus.OK);
    }

    @GetMapping("/singer/{id}")
    public ResponseEntity<Iterable<Song>> getAllSongBySinger(@PathVariable("id") Long id){
        Singer singer = singerService.findOne(id);
        Iterable<Song> songs = songService.findBySinger(singer);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Singer> getSingerById(@PathVariable("id") Long id){
        Singer singer = singerService.findOne(id);
        return new ResponseEntity<>(singer, HttpStatus.OK);
    }

    @GetMapping("/song")
    public ResponseEntity<Iterable<Song>> getAllSong(){
        ArrayList<Song> songs = songService.findAll();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @PostMapping("/song/search")
    public ResponseEntity<Iterable<Song>> getAllSongByName(@RequestBody String name){
        Iterable<Song> songs = songService.findByName(name);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/song/new")
    public ResponseEntity<Iterable<Song>> getAllSongNew() {
        ArrayList<Song> songs = songService.findAll();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/song/like")
    public ResponseEntity<Iterable<Song>> getAllSongByLike() {
        Iterable<Song> songs = songService.findAllByLike();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable("id") Long id){
        Song song = songService.findOne(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @GetMapping("/playlist")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylist() {
        ArrayList<Playlist> playlists = playlistService.findAll();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @PostMapping("/playlist/search")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylistByName(@RequestBody String name) {
        Iterable<Playlist> playlists = playlistService.findByName(name);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/playlist/new")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylistNew() {
        ArrayList<Playlist> playlists = playlistService.findAll();
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/playlist/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable("id") Long id) {
        Playlist playlist = playlistService.findOne(id);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }
}
