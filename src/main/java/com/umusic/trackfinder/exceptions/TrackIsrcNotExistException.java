package com.umusic.trackfinder.exceptions;

public class TrackIsrcNotExistException extends Exception {

    public TrackIsrcNotExistException() {
        super();
    }

    public TrackIsrcNotExistException(String message) {
        super(message);
    }

    public TrackIsrcNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrackIsrcNotExistException(Throwable cause) {
        super(cause);
    }

    protected TrackIsrcNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
