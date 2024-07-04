package com.triptogether.api.common.validator;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    String message() default "Password must be between 4 to 30 characters long.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
