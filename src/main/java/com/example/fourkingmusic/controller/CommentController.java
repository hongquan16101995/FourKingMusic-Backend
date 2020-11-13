package com.example.fourkingmusic.controller;


import com.example.fourkingmusic.models.CommentSong;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.response.MessageResponse;
import com.example.fourkingmusic.service.CommentSongService;
import com.example.fourkingmusic.service.SongService;
import com.example.fourkingmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/{id}")
//    public ResponseEntity<CommentSong> getCommentsong(@PathVariable("id") Long id){
//        CommentSong commentSong = commentSongService.findOne(id);
//        return new ResponseEntity<>(commentSong, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<MessageResponse> comment(@RequestBody CommentSong commentSong){
        commentSongService.saveCommentSong(commentSong);
        String message = "Success";
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<CommentSong>> getCommentsongBySong(@PathVariable("id") Long id){
        Song song = songService.findOne(id);
        Iterable<CommentSong> commentSongs = commentSongService.findAllBySong(song);
        return new ResponseEntity<>(commentSongs, HttpStatus.OK);
    }
}
