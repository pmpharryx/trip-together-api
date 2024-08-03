package com.triptogether.api.common.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class AtLeastOneOfValidator implements ConstraintValidator<AtLeastOneOf, Object> {

    private String[] fields;

    @Override
    public void initialize(AtLeastOneOf annotation) {
        this.fields = annotation.fields();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        // create BeanWrapper object
        BeanWrapper wrappedObject = new BeanWrapperImpl(value);

        int matches = countNumberOfMatches(wrappedObject);

        if (matches == 0) {
            setValidationErrorMessage(context, "one.of.no.matches.message");
            return false;
        }
        return true;
    }

    private int countNumberOfMatches(BeanWrapper wrappedObject) {
        int matches = 0;
        for (String field : this.fields) {
            Object fieldValue = wrappedObject.getPropertyValue(field);
            if (fieldValue != null) {
                matches++;
            }
        }
        return matches;
    }

    private void setValidationErrorMessage(ConstraintValidatorContext context, String template) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate("{" + template + "}").addConstraintViolation();
    }
}
