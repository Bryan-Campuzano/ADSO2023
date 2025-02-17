package com.app.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdDomiciliarioValidador implements ConstraintValidator<IdDomiciliarioAnotacion, Integer> {

    @Override
    public void initialize(IdDomiciliarioAnotacion constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value > 0;
    }
}
