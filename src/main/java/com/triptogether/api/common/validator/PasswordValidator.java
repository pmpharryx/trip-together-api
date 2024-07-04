package com.triptogether.api.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String>

    {
        @Override
        public void initialize(ValidPassword constraintAnnotation) {}

        @Override
        public boolean isValid(String password, ConstraintValidatorContext context) {

        return password != null && password.matches("^.{4,30}$");
        }
    }
