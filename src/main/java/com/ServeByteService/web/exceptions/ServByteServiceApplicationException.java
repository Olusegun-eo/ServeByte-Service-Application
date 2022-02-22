package com.ServeByteService.web.exceptions;

public class ServByteServiceApplicationException extends Throwable{
    public ServByteServiceApplicationException() {
    }

    public ServByteServiceApplicationException(String message) {
        super(message);
    }

    public ServByteServiceApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServByteServiceApplicationException(Throwable cause) {
        super(cause);
    }

    public ServByteServiceApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
