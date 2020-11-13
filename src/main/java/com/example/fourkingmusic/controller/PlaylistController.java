package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Playlist;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.models.Users;
import com.example.fourkingmusic.response.MessageResponse;
import com.example.fourkingmusic.service.PlaylistService;
import com.example.fourkingmusic.service.SongService;
import com.example.fourkingmusic.service.UserService;
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

    @Autowired
    private SongService songService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<MessageResponse> createPlaylist(@RequestBody Playlist playlist) {
        playlist.setDateCreated(new Date());
        String AVATAR_URL = "https://photo-zmp3.zadn.vn/album_default.png";
        playlist.setAvatarUrl(AVATAR_URL);
        playlistService.savePlaylist(playlist);
        String message = "Tạo playlist mới thành công!";
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deletePlaylist(@PathVariable("id") Long id) {
        playlistService.deletePlaylist(id);
        String message = "Xóa playlist thành công!";
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }

    @DeleteMapping("/song/{id}/{songid}")
    public ResponseEntity<MessageResponse> deleteSongOfPlaylist(@PathVariable("id") Long id, @PathVariable("songid") Long songId) {
        Playlist playlist = playlistService.findOne(id);
        Song song = songService.findOne(songId);
        Set<Song> songs = playlist.getSongs();
        String message = "Xóa thành công";
        if (!songs.remove(song)) {
            message = "Xóa thất bại";
        }
        playlistService.savePlaylist(playlist);
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageResponse> editPlaylist(@RequestBody Playlist playlist) {
        playlistService.savePlaylist(playlist);
        String message = "Cập nhật thông playlist thành công!";
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageResponse> updatePlaylist(@PathVariable("id") Long id, @RequestBody Long songId) {
        Playlist playlist = playlistService.findOne(id);
        Song song = songService.findOne(songId);
        Set<Song> songs = playlist.getSongs();
        if (songs.size() == 0) {
            playlist.setAvatarUrl(song.getAvatarUrl());
        }
        String message = "Thêm thành công";
        if (!songs.add(song)) {
            message = "Thêm thất bại";
        }
        playlistService.savePlaylist(playlist);
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }
}
