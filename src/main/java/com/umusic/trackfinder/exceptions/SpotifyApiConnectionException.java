package com.umusic.trackfinder.exceptions;

public class SpotifyApiConnectionException extends Exception {
    public SpotifyApiConnectionException() {
        super();
    }

    public SpotifyApiConnectionException(String message) {
        super(message);
    }

    public SpotifyApiConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpotifyApiConnectionException(Throwable cause) {
        super(cause);
    }

    protected SpotifyApiConnectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
