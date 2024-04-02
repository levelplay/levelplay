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


    // public User searchUser(String username) throws Exception {
    //        log.info("Retrieving user by username....");
    //        User user = userRepository.findByUsername(username);
    //
    //        // Check if the user exists
    //        if (user == null) {
    //            log.info("User does not exists");
    //        }
    //
    //        return user;
    //    }
}
