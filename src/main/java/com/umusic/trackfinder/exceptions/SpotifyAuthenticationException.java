package com.umusic.trackfinder.exceptions;

public class SpotifyAuthenticationException extends Exception {
    public SpotifyAuthenticationException() {
        super();
    }

    public SpotifyAuthenticationException(String message) {
        super(message);
    }

    public SpotifyAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpotifyAuthenticationException(Throwable cause) {
        super(cause);
    }

    protected SpotifyAuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
