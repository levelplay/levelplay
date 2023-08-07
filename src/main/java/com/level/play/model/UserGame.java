package com.level.play.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userGameId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private com.level.play.model.User user;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private com.level.play.model.Game game;

    private int userPoints;

    // Constructors, getters, and setters (optional) - You can generate these using your IDE or write them manually.

    public UserGame() {
        // Default constructor for JPA
    }

    public UserGame(com.level.play.model.User user, com.level.play.model.Game game, int userPoints) {
        this.user = user;
        this.game = game;
        this.userPoints = userPoints;
    }

    // Getters and Setters (generated or written manually)
    // ...

    // You can also override toString() and equals() methods if needed.

    @Override
    public String toString() {
        return "UserGame{" +
                "userGameId=" + userGameId +
                ", user=" + user +
                ", game=" + game +
                ", userPoints=" + userPoints +
                '}';
    }
}
