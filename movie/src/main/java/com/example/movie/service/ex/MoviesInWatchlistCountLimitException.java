package com.example.movie.service.ex;

/* Exception when # of movies within a watchlist exceeds limit(50 movies/watchlist)*/
public class MoviesInWatchlistCountLimitException extends ServiceException{
    public MoviesInWatchlistCountLimitException() {
        super();
    }

    public MoviesInWatchlistCountLimitException(String message) {
        super(message);
    }

    public MoviesInWatchlistCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public MoviesInWatchlistCountLimitException(Throwable cause) {
        super(cause);
    }

    protected MoviesInWatchlistCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
