package com.example.movie.service.ex;

public class MovieInWatchlistDuplicatedException extends ServiceException{
    public MovieInWatchlistDuplicatedException() {
        super();
    }

    public MovieInWatchlistDuplicatedException(String message) {
        super(message);
    }

    public MovieInWatchlistDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovieInWatchlistDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected MovieInWatchlistDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
