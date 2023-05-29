package com.example.movie.service.ex;

public class UserIdNotExistException extends ServiceException{

    public UserIdNotExistException() {
        super();
    }

    public UserIdNotExistException(String message) {
        super(message);
    }

    public UserIdNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIdNotExistException(Throwable cause) {
        super(cause);
    }

    protected UserIdNotExistException(String message, Throwable cause, boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
