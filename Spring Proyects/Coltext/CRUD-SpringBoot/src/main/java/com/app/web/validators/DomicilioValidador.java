package com.app.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DomicilioValidador implements ConstraintValidator<DomicilioAnotacion, String> {

    @Override
    public void initialize(DomicilioAnotacion constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.length() > 255) {
            return false;
        }
        return true;
    }
}
