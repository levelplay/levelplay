package com.level.play.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<com.level.play.model.User, Long> {

    Optional<Object> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
