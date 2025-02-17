package com.app.web.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IdDomiciliarioValidador.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IdDomiciliarioAnotacion {
    String message() default "El ID del domiciliario debe ser un número positivo";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

