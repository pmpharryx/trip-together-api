package com.triptogether.api.common.exception;

import lombok.Getter;

import java.util.Map;


@Getter
public class UserNotFoundException extends RuntimeException{

    private final Map<String, String> errors;

    public UserNotFoundException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }
}