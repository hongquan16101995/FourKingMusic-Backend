package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Commentsong;
import com.example.fourkingmusic.response.MessageResponse;
import com.example.fourkingmusic.service.CommentsongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/commentsong")
public class CommentsongController {
    @Autowired
    private CommentsongService commentsongService;

    @PostMapping
    private ResponseEntity<MessageResponse> updateComment(@RequestBody Commentsong commentsong){
        commentsongService.saveComment(commentsong);
        String message = "Success";
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }
}
