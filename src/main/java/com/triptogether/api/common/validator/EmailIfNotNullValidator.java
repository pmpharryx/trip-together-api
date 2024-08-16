package com.triptogether.api.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailIfNotNullValidator implements ConstraintValidator<ValidEmailIfNotNull, String> {


    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"; //same pattern as in @Email
    @Override
    public void initialize(ValidEmailIfNotNull constraintAnnotation) {}

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        return email == null || email.matches(EMAIL_REGEX);
    }
}
