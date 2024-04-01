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

@CrossOrigin
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public UserController(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @PostMapping("/ping")
    public ResponseEntity<String> ping() {

        return new ResponseEntity<>("The application is up", HttpStatus.OK);
    }


    @PostMapping("/register")
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        // Validate user data (optional)

        // Save the user in the database
        User savedUser = userService.registerUser(user);

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        log.info("Performing login...");
        try {
            // Check if the user exists and password matches
            boolean authenticated = userService.authenticateUser(user.getUsername(), user.getPassword());

            if (authenticated) {
                log.info("Login successful!");
                return new ResponseEntity<>("Login successful!", HttpStatus.OK);
            } else {
                log.info("Login unsuccessful!");
                return new ResponseEntity<>("Invalid username or password.", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            log.error("Exception during login: {}", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/search/user")
    public ResponseEntity<Object> searchUser(@RequestBody String username) throws Exception {
        com.level.play.model.User user = userService.searchUser(username);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
    }

    //forgot password api
}
