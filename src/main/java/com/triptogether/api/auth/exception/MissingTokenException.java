package com.triptogether.api.auth.exception;


import lombok.Getter;

import java.util.Map;

@Getter
public class MissingTokenException extends RuntimeException {
    private final Map<String, String> errors;

    public MissingTokenException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }
}
