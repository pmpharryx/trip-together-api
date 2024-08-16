package com.triptogether.api.auth.exception;


import lombok.Getter;

import java.util.Map;

@Getter
public class MissingTokenException extends RuntimeException {

    String statusCode;
    private final Map<String, String> errors;

    public MissingTokenException(String message, String statusCode ,Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }
}
