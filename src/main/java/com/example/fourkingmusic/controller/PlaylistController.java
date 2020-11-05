package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Playlist;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Controller
@CrossOrigin("*")
@RequestMapping("/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping
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

    @GetMapping("/user")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylistOfUser(@RequestBody Users user) {
        Iterable<Playlist> playlists = playlistService.findByUser(user);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylistByName(@RequestBody String name) {
        Iterable<Playlist> playlists = playlistService.findByName(name);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/new")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylistNew() {
        ArrayList<Playlist> playlists = playlistService.findAll();
        ArrayList<Playlist> playlistArrayList = new ArrayList<>();
        int count = 0;
        for (int i = (playlists.size()-1); i > 0; i--) {
            playlistArrayList.add(playlists.get(i));
            count++;
            if (count == 10) {
                break;
            }
        }
        return new ResponseEntity<>(playlistArrayList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(@PathVariable("id") Long id) {
        Playlist playlist = playlistService.findOne(id);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
        playlist.setDateCreated(new Date());
        playlistService.savePlaylist(playlist);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Playlist> deletePlaylist(@PathVariable("id") Long id) {
        playlistService.deletePlaylist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/song/{id}")
    public ResponseEntity<String> deleteSongOfPlaylist(@PathVariable("id") Long id, @RequestBody Song song) {
        Playlist playlist = playlistService.findOne(id);
        Set<Song> songs = playlist.getSongs();
        String message = "Thành công";
        if (!songs.remove(song)) {
            message = "Thất bại";
        }
        playlistService.savePlaylist(playlist);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlaylist(@PathVariable("id") Long id, @RequestBody Song song) {
        Playlist playlist = playlistService.findOne(id);
        Set<Song> songs = playlist.getSongs();
        String message = "Thành công";
        if (!songs.add(song)) {
            message = "Thất bại";
        }
        playlistService.savePlaylist(playlist);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Playlist> editPlaylist(@RequestBody Playlist playlist) {
        playlistService.savePlaylist(playlist);
        return new ResponseEntity<>(playlist, HttpStatus.OK);
    }
}
