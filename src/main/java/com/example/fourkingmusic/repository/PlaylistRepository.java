package com.example.fourkingmusic.repository;

import com.example.fourkingmusic.models.Playlist;
import com.example.fourkingmusic.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends CrudRepository<Playlist, Long> {
    Iterable<Playlist> findAllByUser(Users user);

    Iterable<Playlist> findAllByNameContaining(String name);
}
