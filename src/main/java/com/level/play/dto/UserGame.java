package com.level.play.dto;

import lombok.Data;

@Data
public class UserGame {

    private com.level.play.dto.User user;
    private com.level.play.dto.Game game;
    private int userPoints;
}
