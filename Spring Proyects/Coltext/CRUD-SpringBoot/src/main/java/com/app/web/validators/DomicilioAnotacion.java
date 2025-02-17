package com.app.web.validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DomicilioValidador.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DomicilioAnotacion {
    String message() default "Invalid Resumen";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}