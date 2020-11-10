package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Password;
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
    public ResponseEntity<MessageResponse> changeInfomations(@RequestBody Users user){
        userService.updateUser(user);
        String message = "Cập nhât thông tin thành công!";
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }

    @PostMapping("/changepassword")
    public ResponseEntity<MessageResponse> changePassword(@RequestBody Password password) {
        Users user = userService.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName());
        String message;
        if(userService.checkPassword(user, password.getPassword())){
            user.setPassword(passwordEncoder.encode(password.getNewpassword()));
            userService.updateUser(user);
            message = "Đã đổi mật khẩu thành công!";
        }else {
            message = "Đổi mật khẩu thất bại!";
        }
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long id){
        Users user = userService.findOne(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/song")
    public ResponseEntity<Iterable<Song>> getAllSongOfUser(@RequestBody Long userId){
        Users user = userService.findOne(userId);
        Iterable<Song> songs = songService.findByUser(user);
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/playlist")
    public ResponseEntity<Iterable<Playlist>> getAllPlaylistOfUser(@RequestBody Long userId) {
        Users user = userService.findOne(userId);
        Iterable<Playlist> playlists = playlistService.findByUser(user);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }
}
