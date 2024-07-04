package com.triptogether.api.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MobileNoValidator implements ConstraintValidator<ValidMobileNo, String>

{
    @Override
    public void initialize(ValidMobileNo constraintAnnotation) {}

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        return password != null && password.matches("^.{1,15}$");
    }
}
