package com.triptogether.api.common.exception;

import lombok.Getter;

import java.util.Map;


@Getter
public class UpdateUserProfileErrorException extends RuntimeException{

    private final Map<String, String> errors;

    public UpdateUserProfileErrorException(String message, Map<String, String> errors) {
        super(message);
        this.errors = errors;
    }
}