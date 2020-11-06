package com.example.fourkingmusic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
    Optional<Users> findUsersByUsername(String username);
    Boolean existsUsersByUsername(String username);
    Boolean existsUsersByEmail(String email);
    Users findByUsername(String username);
}
