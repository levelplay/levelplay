package com.level.play.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tournament")
@Data
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tournamentName;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private com.level.play.model.Game game;

    private Date startDate;

    private Date endDate;

}
