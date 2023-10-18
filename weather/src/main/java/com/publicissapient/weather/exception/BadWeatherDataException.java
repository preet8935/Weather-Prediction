package com.publicissapient.weather.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadWeatherDataException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new bad weather data exception.
     *
     * @param message the message
     */
    public BadWeatherDataException(String message) {
        super(message);
    }

    /**
     * Instantiates a new bad weather data exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public BadWeatherDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
