package com.example.fourkingmusic.repository;

import com.example.fourkingmusic.models.Song;
import com.example.fourkingmusic.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    Iterable<Song> findAllByUser(Users user);

    Iterable<Song> findAllByNameContaining(String name);
}
