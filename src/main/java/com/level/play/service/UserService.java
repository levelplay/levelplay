package com.level.play.service;

import com.level.play.model.User;
import com.level.play.repository.GameRepository;
import com.level.play.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, GameRepository gameRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public com.level.play.dto.User registerUser(com.level.play.dto.User user) {
        // Check if the username or email is already taken
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new IllegalArgumentException("Username already taken");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }

        // Hash the user's password before saving it to the database
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        com.level.play.model.User userEntity = new com.level.play.model.User();
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(encodedPassword);
        userEntity.setProfilePicture(user.getProfilePicture());

        // Save the user in the database
        userRepository.save(userEntity);

        return user;
    }

    public boolean authenticateUser(String username, String password) {
        log.info("Verifying the user exists...");
        User user = userRepository.findByUsername(username);

        // Check if the user exists
        if (user == null) {
            log.info("User does not exist.");
            return false; // User not found, return false
        }

        // Check if the entered password matches the stored password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            log.info("Password and email do not match");
            return false; // Invalid password, return false
        }

        return true;
    }

    public User searchUser(String username) throws Exception {
        log.info("Retrieving user by username....");
        User user = userRepository.findByUsername(username);

        // Check if the user exists
        if (user == null) {
            log.info("User does not exists");
        }

        return user;
    }
}
