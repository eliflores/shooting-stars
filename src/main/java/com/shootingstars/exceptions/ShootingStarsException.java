package com.shootingstars.exceptions;

public class ShootingStarsException extends RuntimeException {
    private ShootingStarsException(String message, Throwable cause) {
        super(message, cause);
    }

    public static ShootingStarsException exception(String message, Throwable cause) {
        return new ShootingStarsException(message, cause);
    }
}
