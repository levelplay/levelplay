package com.level.play.repository;

import com.level.play.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Object> findByGameName(String title);
}
