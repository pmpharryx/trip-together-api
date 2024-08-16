package com.triptogether.api.auth.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class DatabaseConstrainViolationException extends RuntimeException{

    String statusCode;
    private final Map<String, String> errors;

    public DatabaseConstrainViolationException(String message, String statusCode ,Map<String, String> errors) {
        super(message);
        this.statusCode = statusCode;
        this.errors = errors;

    }
}
