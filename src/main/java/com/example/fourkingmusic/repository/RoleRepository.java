package com.example.fourkingmusic.repository;

import com.example.fourkingmusic.models.ERole;
import com.example.fourkingmusic.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(ERole name);
}
