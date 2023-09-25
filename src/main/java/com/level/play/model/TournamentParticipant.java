package com.level.play.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tournament_participant")
@Data
public class TournamentParticipant {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="default_id_seq")
    @SequenceGenerator(name="default_id_seq", sequenceName = "default_id_seq", allocationSize=1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private com.level.play.model.Tournament tournament;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private com.level.play.model.User user;
}
