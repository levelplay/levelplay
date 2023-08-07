package com.level.play.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long challengeId;

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

    // Constructors, getters, and setters (optional) - You can generate these using your IDE or write them manually.

    public Challenge() {
        // Default constructor for JPA
    }

    public Challenge(com.level.play.model.User challenger, com.level.play.model.User opponent, com.level.play.model.Game game, Date challengeDate, String challengeStatus, String challengeResult) {
        this.challenger = challenger;
        this.opponent = opponent;
        this.game = game;
        this.challengeDate = challengeDate;
        this.challengeStatus = challengeStatus;
        this.challengeResult = challengeResult;
    }

    // Getters and Setters (generated or written manually)
    // ...

    // You can also override toString() and equals() methods if needed.

    @Override
    public String toString() {
        return "Challenge{" +
                "challengeId=" + challengeId +
                ", challenger=" + challenger +
                ", opponent=" + opponent +
                ", game=" + game +
                ", challengeDate=" + challengeDate +
                ", challengeStatus='" + challengeStatus + '\'' +
                ", challengeResult='" + challengeResult + '\'' +
                '}';
    }
}
