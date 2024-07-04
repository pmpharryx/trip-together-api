package com.triptogether.api.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UsernameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUsername {

    String message() default "Username must only contains alphabet characters, numbers, and underscores between 1 - 16 characters long.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
