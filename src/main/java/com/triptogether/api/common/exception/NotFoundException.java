package com.triptogether.api.common.exception;

import lombok.Getter;

import java.util.Map;


@Getter
public class NotFoundException extends RuntimeException{

    String statusCode;
    private final Map<String, String> errors;

    public NotFoundException(String message, String statusCode ,Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }
}