package com.example.movie.service.ex;

public class ParameterMissingException extends ServiceException{
    public ParameterMissingException() {
        super();
    }

    public ParameterMissingException(String message) {
        super(message);
    }

    public ParameterMissingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterMissingException(Throwable cause) {
        super(cause);
    }

    protected ParameterMissingException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }
}
