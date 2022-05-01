package com.umusic.trackfinder.exceptions;

public class SpotifyFormatResponseException extends Exception {
    public SpotifyFormatResponseException() {
        super();
    }

    public SpotifyFormatResponseException(String message) {
        super(message);
    }

    public SpotifyFormatResponseException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpotifyFormatResponseException(Throwable cause) {
        super(cause);
    }

    protected SpotifyFormatResponseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
