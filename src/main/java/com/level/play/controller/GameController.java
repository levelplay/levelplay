package com.level.play.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.level.play.dto.Game;
import com.level.play.dto.User;
import com.level.play.service.GameService;
import com.level.play.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
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
    public ResponseEntity<Object> searchGame(@RequestBody String requestBody) throws JsonProcessingException {
        // Validate username and password (optional)
        log.info("Game api controller invoked...");
        ObjectMapper objectMapper = new ObjectMapper();
        Game gameDto = objectMapper.readValue(requestBody, Game.class);


        // Check if the game exists and password matches
        //TODO: implement list to return simliar game titles

        com.level.play.model.Game game = gameService.searchGame(gameDto.getGameName());
        if (game != null) {
            return new ResponseEntity<>(game, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Game not found.", HttpStatus.UNAUTHORIZED);
        }
    }
}
