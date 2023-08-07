package com.level.play.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TournamentParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournamentParticipantId;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private com.level.play.model.Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private com.level.play.model.User user;

    // Constructors, getters, and setters (optional) - You can generate these using your IDE or write them manually.

    public TournamentParticipant() {
        // Default constructor for JPA
    }

    public TournamentParticipant(com.level.play.model.Tournament tournament, com.level.play.model.User user) {
        this.tournament = tournament;
        this.user = user;
    }

    // Getters and Setters (generated or written manually)
    // ...

    // You can also override toString() and equals() methods if needed.

    @Override
    public String toString() {
        return "TournamentParticipant{" +
                "tournamentParticipantId=" + tournamentParticipantId +
                ", tournament=" + tournament +
                ", user=" + user +
                '}';
    }
}
