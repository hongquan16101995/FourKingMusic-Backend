package com.example.fourkingmusic.controller;


import com.example.fourkingmusic.models.CommentSong;
import com.example.fourkingmusic.service.CommentSongService;
import com.example.fourkingmusic.service.SongService;
import com.example.fourkingmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/commentsong")
public class CommentController {
    @Autowired
    private CommentSongService commentSongService;

    @Autowired
    private UserService userService;

    @Autowired
    private SongService songService;

    @GetMapping
    public ResponseEntity<Iterable<CommentSong>> getAllCommentSong() {
        Iterable<CommentSong> commentSongs = commentSongService.findAll();
        return new ResponseEntity<>(commentSongs, HttpStatus.OK);
    }
}
