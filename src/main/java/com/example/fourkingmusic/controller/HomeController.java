package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Playlist;
import com.example.fourkingmusic.models.Singer;
import com.example.fourkingmusic.models.Song;
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

    @GetMapping("/singer/{id}")
    public ResponseEntity<Singer> getSingerById(@PathVariable("id") Long id){
        Singer singer = singerService.findOne(id);
        return new ResponseEntity<>(singer, HttpStatus.OK);
    }

    @GetMapping("/singer/search")
    public ResponseEntity<Iterable<Singer>> getAllSingerByName(@RequestBody String name){
        Iterable<Singer> singers = singerService.findByName(name);
        return new ResponseEntity<>(singers, HttpStatus.OK);
    }

    @GetMapping("/song")
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

    @GetMapping("/song/search")
    public ResponseEntity<Iterable<Song>> getAllSongByName(@RequestBody String name){
        Iterable<Song> songs = songService.findByName(name);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/song/new")
    public ResponseEntity<Iterable<Song>> getAllSongNew() {
        ArrayList<Song> songs = songService.findAll();
        ArrayList<Song> songArrayList = new ArrayList<>();
        int count = 0;
        for (int i = (songs.size()-1); i >= 0; i--) {
            songArrayList.add(songs.get(i));
            count++;
            if (count == 7) {
                break;
            }
        }
        return new ResponseEntity<>(songArrayList, HttpStatus.OK);
    }

    @GetMapping("/song/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable("id") Long id){
        Song song = songService.findOne(id);
        return new ResponseEntity<>(song, HttpStatus.OK);
    }

    @GetMapping("/playlist")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylist() {
        ArrayList<Playlist> playlists = playlistService.findAll();
        ArrayList<Playlist> playlistArrayList = new ArrayList<>();
        int count = 0;
        for (Playlist playlist : playlists) {
            playlistArrayList.add(playlist);
            count++;
            if (count == 7) {
                break;
            }
        }
        return new ResponseEntity<>(playlistArrayList, HttpStatus.OK);
    }

    @GetMapping("/playlist/search")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylistByName(@RequestBody String name) {
        Iterable<Playlist> playlists = playlistService.findByName(name);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/playlist/new")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylistNew() {
        ArrayList<Playlist> playlists = playlistService.findAll();
        ArrayList<Playlist> playlistArrayList = new ArrayList<>();
        int count = 0;
        for (int i = (playlists.size()-1); i >= 0; i--) {
            playlistArrayList.add(playlists.get(i));
            count++;
            if (count == 7) {
                break;
            }
        }
        return new ResponseEntity<>(playlistArrayList, HttpStatus.OK);
    }

    @GetMapping("/playlist/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable("id") Long id) {
        Playlist playlist = playlistService.findOne(id);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }
}
