package com.example.movie.service.ex;

public class WatchlistIdNotExistException extends ServiceException{
    public WatchlistIdNotExistException() {
        super();
    }

    public WatchlistIdNotExistException(String message) {
        super(message);
    }

    public WatchlistIdNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public WatchlistIdNotExistException(Throwable cause) {
        super(cause);
    }

    protected WatchlistIdNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
