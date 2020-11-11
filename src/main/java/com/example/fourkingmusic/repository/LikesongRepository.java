package com.example.fourkingmusic.repository;

import com.example.fourkingmusic.models.Likesong;
import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesongRepository extends CrudRepository<Likesong, Long> {
    Likesong findByUserAndSong(Users user, Song song);
}
