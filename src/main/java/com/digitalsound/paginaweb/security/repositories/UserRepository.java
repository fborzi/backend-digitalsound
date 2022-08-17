package com.digitalsound.paginaweb.security.repositories;

import com.digitalsound.paginaweb.security.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {
//    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findByUsername(String username);
    boolean existsByUsername(String username);
//    boolean existsByEmail(String email);
}
