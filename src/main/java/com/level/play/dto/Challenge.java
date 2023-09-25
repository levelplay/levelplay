package com.level.play.dto;

import lombok.Data;
import java.util.Date;

@Data
public class Challenge {
    private com.level.play.dto.User challenger;
    private com.level.play.dto.User opponent;
    private com.level.play.dto.Game game;
    private Date challengeDate;
    private String challengeStatus;
    private String challengeResult;
}
