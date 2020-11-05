package com.example.fourkingmusic.repository;

import com.example.fourkingmusic.models.Singer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepository extends CrudRepository<Singer, Long> {
    Iterable<Singer> findAllByNameContaining(String name);
}
