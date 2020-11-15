package com.example.fourkingmusic.repository;

import com.example.fourkingmusic.models.Likeplaylist;
import com.example.fourkingmusic.models.Playlist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeplaylistRepository extends CrudRepository<Likeplaylist, Long> {
    Iterable<Likeplaylist> findAllByPlaylist(Playlist playlist);
}
