package com.example.movie.service.ex;

/* Exception when # of watchlists of a user exceed(10 watchlists)*/
public class WatchlistCountLimitException extends ServiceException{
    public WatchlistCountLimitException() {
        super();
    }

    public WatchlistCountLimitException(String message) {
        super(message);
    }

    public WatchlistCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public WatchlistCountLimitException(Throwable cause) {
        super(cause);
    }

    protected WatchlistCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
