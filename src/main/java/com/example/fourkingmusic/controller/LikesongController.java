package com.example.fourkingmusic.controller;


import com.example.fourkingmusic.models.Likesong;
import com.example.fourkingmusic.response.MessageResponse;
import com.example.fourkingmusic.service.LikesongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/likesong")
public class LikesongController {
    @Autowired
    private LikesongService likesongService;

    @GetMapping
    public ResponseEntity<Iterable<Likesong>> getAllLikesong(){
        Iterable<Likesong> likesongs = likesongService.findAll();
        return new ResponseEntity<>(likesongs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Likesong> getLikesong(@PathVariable("id") Long id){
        Likesong likesong = likesongService.findOne(id);
        return new ResponseEntity<>(likesong, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> like(@RequestBody Likesong likesong){
        likesongService.saveLikesong(likesong);
        String message = "Success";
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }
}
