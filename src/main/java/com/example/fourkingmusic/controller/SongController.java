package com.example.fourkingmusic.controller;

import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.models.Users;
import com.example.fourkingmusic.response.MessageResponse;
import com.example.fourkingmusic.service.SongService;
import com.example.fourkingmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@CrossOrigin("*")
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<MessageResponse> createSong(@RequestBody Song song){
        song.setDateCreated(new Date());
        songService.saveSong(song);
        String message = "Tạo bài hát mới thành công!";
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteSong(@PathVariable("id") Long id, @RequestBody Long userId){
        Song song = songService.findOne(id);
        Users user = userService.findOne(userId);
        String message;
        if(song == null){
            message = "Không có bài hát phù hợp!";
        } else if(song.getUser().equals(user)){
            songService.deleteSong(id);
            message = "Xóa bài hát thành công!";
        } else {
            message = "Bạn không có quyền thực hiện tác vụ này!";
        }
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<MessageResponse> updateSong(@RequestBody Song song){
        songService.saveSong(song);
        String message = "Cập nhật thông tin bài hát thành công!";
        return new ResponseEntity<>(new MessageResponse(message), HttpStatus.OK);
    }
}
