package com.example.fourkingmusic.controller;


import com.example.fourkingmusic.models.Likesong;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.models.Users;
import com.example.fourkingmusic.response.MessageResponse;
import com.example.fourkingmusic.service.LikesongService;
import com.example.fourkingmusic.service.SongService;
import com.example.fourkingmusic.service.UserService;
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

    @Autowired
    private UserService userService;

    @Autowired
    private SongService songService;

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

//    @PostMapping("/{id}")
//    public ResponseEntity<Boolean> getLikesongUserAndSong(@PathVariable("id") Long songId,
//                                                          @RequestBody Long userId){
//        Users user = userService.findOne(userId);
//        Song song =
//    }
}
