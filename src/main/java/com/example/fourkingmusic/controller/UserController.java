package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Password;
import com.example.fourkingmusic.models.Playlist;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.models.Users;
import com.example.fourkingmusic.service.PlaylistService;
import com.example.fourkingmusic.service.SongService;
import com.example.fourkingmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SongService songService;

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/changeinfo")
    public ResponseEntity<String> changeInfomations(@RequestBody Users user){
        userService.updateUser(user);
        String message = "Update successful";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/changepassword")
    public ResponseEntity<String> changePassword(@RequestBody Password password) {
        Users user = userService.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        String message;
        if(userService.checkPassword(user, password.getPassword())){
            user.setPassword(passwordEncoder.encode(password.getNewpassword()));
            userService.updateUser(user);
            message = "Change password successful";
        }else {
            message = "Change password failure";
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long id){
        Users user = userService.findOne(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/song")
    public ResponseEntity<Iterable<Song>> getAllSongOfUser(@RequestBody Users user){
        Iterable<Song> songs = songService.findByUser(user);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/playlist")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylistOfUser(@RequestBody Users user) {
        Iterable<Playlist> playlists = playlistService.findByUser(user);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }
}
