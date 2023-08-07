package com.level.play.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournamentId;

    private String tournamentName;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private com.level.play.model.Game game;

    private Date startDate;

    private Date endDate;

    // Constructors, getters, and setters (optional) - You can generate these using your IDE or write them manually.

    public Tournament() {
        // Default constructor for JPA
    }

    public Tournament(String tournamentName, com.level.play.model.Game game, Date startDate, Date endDate) {
        this.tournamentName = tournamentName;
        this.game = game;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters (generated or written manually)
    // ...

    // You can also override toString() and equals() methods if needed.

    @Override
    public String toString() {
        return "Tournament{" +
                "tournamentId=" + tournamentId +
                ", tournamentName='" + tournamentName + '\'' +
                ", game=" + game +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
