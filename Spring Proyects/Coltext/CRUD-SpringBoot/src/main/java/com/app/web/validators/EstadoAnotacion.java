package com.app.web.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EstadoValidador.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EstadoAnotacion {
    String message() default "El estado debe estar entre 1 y 10";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}