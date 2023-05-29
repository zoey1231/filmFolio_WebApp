package com.example.movie.service.ex;

public class EmailNotExistException extends ServiceException{
    public EmailNotExistException() {
        super();
    }

    public EmailNotExistException(String message) {
        super(message);
    }

    public EmailNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailNotExistException(Throwable cause) {
        super(cause);
    }

    protected EmailNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
