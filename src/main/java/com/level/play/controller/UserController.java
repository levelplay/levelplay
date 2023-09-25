package com.level.play.controller;

import com.level.play.dto.Game;
import com.level.play.dto.User;
import com.level.play.service.GameService;
import com.level.play.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public UserController(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        // Validate user data (optional)

        // Save the user in the database
        User savedUser = userService.registerUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String username, @RequestParam String password) {
        // Validate username and password (optional)

        // Check if the user exists and password matches
        boolean authenticated = userService.authenticateUser(username, password);
        if (authenticated) {
            return new ResponseEntity<>("Login successful!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid username or password.", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/search/user")
    public ResponseEntity<Object> searchUser(@RequestParam String username) {
        User user = userService.searchUser(username);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/search/game")
    public ResponseEntity<Object> searchGame(@RequestParam String title) {
        // Validate username and password (optional)

        // Check if the game exists and password matches
        Game game = gameService.searchGame(title);
        if (game != null) {
            return new ResponseEntity<>(game, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Game not found.", HttpStatus.UNAUTHORIZED);
        }
    }
}
