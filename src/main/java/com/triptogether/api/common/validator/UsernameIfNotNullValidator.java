package com.triptogether.api.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameIfNotNullValidator implements ConstraintValidator<ValidUsernameIfNotNull, String> {

    @Override
    public void initialize(ValidUsernameIfNotNull constraintAnnotation) {}

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {

        return username == null || username.matches("^[a-zA-Z0-9_]{1,16}$");
    }
}
