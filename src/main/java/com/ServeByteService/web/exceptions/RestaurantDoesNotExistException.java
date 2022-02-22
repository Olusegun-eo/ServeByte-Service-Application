package com.ServeByteService.web.exceptions;

public class RestaurantDoesNotExistException extends Throwable {
    public RestaurantDoesNotExistException(String message) {
        super(message);
    }
}
