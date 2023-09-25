package com.level.play.controller;

import com.level.play.dto.Game;
import com.level.play.dto.User;
import com.level.play.service.GameService;
import com.level.play.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/games")
@Slf4j
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/search/game")
    public ResponseEntity<Object> searchGame(@RequestParam String title) {
        // Validate username and password (optional)
        log.info("Game api controller invoked...");

        // Check if the game exists and password matches
        //TODO: implement list to return simliar game titles
        Game game = gameService.searchGame(title);
        if (game != null) {
            return new ResponseEntity<>(game, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Game not found.", HttpStatus.UNAUTHORIZED);
        }
    }
}
