package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Playlist;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.models.Users;
import com.example.fourkingmusic.response.MessageResponse;
import com.example.fourkingmusic.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@Controller
@CrossOrigin("*")
@RequestMapping("/playlist")
public class PlaylistController {
    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/user")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylistOfUser(@RequestBody Users user) {
        Iterable<Playlist> playlists = playlistService.findByUser(user);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> createPlaylist(@RequestBody Playlist playlist) {
        playlist.setDateCreated(new Date());
        playlistService.savePlaylist(playlist);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
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
