package com.level.play.service;

import com.level.play.dto.Game;
import com.level.play.exception.GameTitleNotFoundException;
import com.level.play.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game searchGame(String title) {
        // Load the game from the database using the userRepository
        Game game = (Game) gameRepository.findByGameName(title)
                .orElseThrow(() -> new GameTitleNotFoundException("Game not found with title: " + title));

        return game;
    }

}
