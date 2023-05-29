package com.example.movie.service.ex;

public class MovieIdNotExistException extends ServiceException{
    public MovieIdNotExistException() {
        super();
    }

    public MovieIdNotExistException(String message) {
        super(message);
    }

    public MovieIdNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public MovieIdNotExistException(Throwable cause) {
        super(cause);
    }

    protected MovieIdNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
