package com.example.fourkingmusic.repository;

import com.example.fourkingmusic.models.Commentplaylist;
import com.example.fourkingmusic.models.Playlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentplaylistRepository extends CrudRepository<Commentplaylist, Long> {
    Iterable<Commentplaylist> findAllByPlaylist(Playlist playlist);
}
