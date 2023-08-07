package com.level.play.dto;

import lombok.Data;

@Data
public class TournamentParticipant {
    private Tournament tournament;
    private User user;
}
