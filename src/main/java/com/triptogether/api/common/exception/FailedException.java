package com.triptogether.api.common.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class FailedException extends RuntimeException{

    String statusCode;
    private final Map<String, String> errors;

    public FailedException(String message, String statusCode ,Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }
}