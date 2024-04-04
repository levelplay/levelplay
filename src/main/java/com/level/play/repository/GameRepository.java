package com.level.play.repository;

import com.level.play.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

    Game findByGameName(String title);

    boolean existsByGameName(String title);
}
