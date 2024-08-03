package com.triptogether.api.auth.exception;

import lombok.Getter;

import java.util.Map;


@Getter
public class SignUpErrorException extends RuntimeException{

    private final Map<String, String> errors;

    public SignUpErrorException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }
}