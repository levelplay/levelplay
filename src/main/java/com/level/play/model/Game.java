package com.level.play.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    private String gameName;

    private String gameDescription;

    private String player1;

    private String player2;

    // Constructors, getters, and setters (optional) - You can generate these using your IDE or write them manually.

    public Game() {
        // Default constructor for JPA
    }

    public Game(String gameName, String gameDescription, String player1, String player2) {
        this.gameName = gameName;
        this.gameDescription = gameDescription;
        this.player1 = player1;
        this.player2 = player2;
    }

    // Getters and Setters (generated or written manually)
    // ...

    // You can also override toString() and equals() methods if needed.

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", gameName='" + gameName + '\'' +
                ", gameDescription='" + gameDescription + '\'' +
                ", player1='" + player1 + '\'' +
                ", player2='" + player2 + '\'' +
                '}';
    }
}
