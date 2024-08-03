package com.triptogether.api.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MobileNoIfNotNullValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMobileNoIfNotNull {

    String message() default "Invalid phone number format.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}