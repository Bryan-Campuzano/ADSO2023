package com.app.web.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EstadoValidador implements ConstraintValidator<EstadoAnotacion, Integer> {

    @Override
    public void initialize(EstadoAnotacion constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return value >= 1 && value <= 10;
    }
}
