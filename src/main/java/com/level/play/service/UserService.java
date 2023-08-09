package com.level.play.service;

import com.level.play.dto.User;
import com.level.play.repository.GameRepository;
import com.level.play.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public User registerUser(User user) {
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
        // Load the user from the database using the userRepository
        User user = (User) userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Check if the provided password matches the stored hashed password
        return passwordEncoder.matches(password, user.getPassword());
    }

    public User searchUser(String username) {
        // Load the user from the database using the userRepository
        User user = (User) userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return user;
    }

    // Other methods for user-related operations
}
