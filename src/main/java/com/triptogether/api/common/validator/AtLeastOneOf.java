package com.triptogether.api.common.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {AtLeastOneOfValidator.class})
@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface AtLeastOneOf {

    String message() default "{one.of.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] fields();
}