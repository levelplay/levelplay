package com.level.play.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_game")
@Data
public class UserGame {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="default_id_seq")
    @SequenceGenerator(name="default_id_seq", sequenceName = "default_id_seq", allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private com.level.play.model.User user;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private com.level.play.model.Game game;

    private int userPoints;

}
