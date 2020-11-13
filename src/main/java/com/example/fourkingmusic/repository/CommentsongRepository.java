package com.example.fourkingmusic.repository;

import com.example.fourkingmusic.models.Commentsong;
import com.example.fourkingmusic.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsongRepository extends CrudRepository<Commentsong, Long> {
    Iterable<Commentsong> findAllBySong(Song song);
}
