package com.level.play.service;

import com.level.play.model.Game;
import com.level.play.repository.GameRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game searchGame(String title) {
        // Load the game from the database using the userRepository
        Game game = gameRepository.findByGameName(title);
//                .orElseThrow(() -> new GameTitleNotFoundException("Game not found with title: " + title));

        if(game == null){
            log.info("User does not exists");
        }
        return game;
    }


    public com.level.play.model.Game addGame(com.level.play.dto.Game game) {
        // Check if the game or email is already taken
        if (gameRepository.existsByGameName(game.getGameName())) {
            throw new IllegalArgumentException("Game already exists");
        }

        com.level.play.model.Game gameEntity = new com.level.play.model.Game();
        gameEntity.setGameName(game.getGameName());
        gameEntity.setGameDescription(game.getGameDescription());

        // Save the game in the database
        gameRepository.save(gameEntity);

        return gameEntity;
    }

}
