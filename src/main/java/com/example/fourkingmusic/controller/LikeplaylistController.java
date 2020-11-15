package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Likeplaylist;
import com.example.fourkingmusic.response.MessageResponse;
import com.example.fourkingmusic.service.LikeplaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/likeplaylist")
public class LikeplaylistController {
    @Autowired
    private LikeplaylistService likeplaylistService;

    @GetMapping
    public ResponseEntity<Iterable<Likeplaylist>> getAllLikeplaylist(){
        Iterable<Likeplaylist> likeplaylists = likeplaylistService.findAll();
        return new ResponseEntity<>(likeplaylists, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> likeplaylist(@RequestBody Likeplaylist likeplaylist){
        likeplaylistService.saveLikeplaylist(likeplaylist);
        String message = "Success";
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }
}
