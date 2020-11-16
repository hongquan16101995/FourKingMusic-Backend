package com.example.fourkingmusic.controller;
import com.example.fourkingmusic.models.Commentplaylist;
import com.example.fourkingmusic.response.MessageResponse;
import com.example.fourkingmusic.service.CommentplaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@CrossOrigin("*")
@RequestMapping("/commentplaylist")
public class CommentplaylistController {
    @Autowired
    private CommentplaylistService commentplaylistService;
    @PostMapping
    private ResponseEntity<MessageResponse> updateComment(@RequestBody Commentplaylist commentplaylist){
        commentplaylistService.saveCommentplaylist(commentplaylist);
        String message = "Success";
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }
}
