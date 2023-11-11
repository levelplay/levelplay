package com.level.play.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "challenges")
@Data
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "challenger_id")
    private com.level.play.model.User challenger;

    @ManyToOne
    @JoinColumn(name = "opponent_id")
    private com.level.play.model.User opponent;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private com.level.play.model.Game game;

    private Date challengeDate;

    private String challengeStatus;

    private String challengeResult;

}
