package com.level.play.exception;

public class GameTitleNotFoundException extends RuntimeException {

    public GameTitleNotFoundException() {
        super();
    }

    public GameTitleNotFoundException(String message) {
        super(message);
    }

    public GameTitleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public GameTitleNotFoundException(Throwable cause) {
        super(cause);
    }
}
