package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Commentsong;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.response.MessageResponse;
import com.example.fourkingmusic.service.CommentsongService;
import com.example.fourkingmusic.service.SongService;
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
    private CommentsongService commentsongService;

    @Autowired
    private SongService songService;

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<Commentsong>> getAllCommentBySong(@PathVariable("id") Long id){
        Song song = songService.findOne(id);
        Iterable<Commentsong> comments = commentsongService.findAllBySong(song);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<MessageResponse> updateComment(@RequestBody Commentsong commentsong){
        commentsongService.saveComment(commentsong);
        String message = "Success";
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }
}
