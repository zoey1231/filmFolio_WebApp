package com.example.movie.service.ex;

public class WatchlistNameDuplicatedException extends ServiceException{
    public WatchlistNameDuplicatedException() {
        super();
    }

    public WatchlistNameDuplicatedException(String message) {
        super(message);
    }

    public WatchlistNameDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public WatchlistNameDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected WatchlistNameDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
