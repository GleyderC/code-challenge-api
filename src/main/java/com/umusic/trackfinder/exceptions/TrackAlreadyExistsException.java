package com.umusic.trackfinder.exceptions;

public class TrackAlreadyExistsException extends Exception {
    public TrackAlreadyExistsException() {
        super();
    }

    public TrackAlreadyExistsException(String message) {
        super(message);
    }

    public TrackAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrackAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    protected TrackAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
