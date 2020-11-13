package com.example.fourkingmusic.repository;

import com.example.fourkingmusic.models.CommentSong;
import com.example.fourkingmusic.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentSongRepository extends CrudRepository<CommentSong, Long> {
    Iterable<CommentSong> findAllBySong(Song song);
}
