package com.level.play.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "game")
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gameName;

    private String gameDescription;

    private String player1;

    private String player2;

}
