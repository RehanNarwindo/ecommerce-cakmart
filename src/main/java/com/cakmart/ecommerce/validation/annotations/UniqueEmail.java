package com.cakmart.ecommerce.validation.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import com.cakmart.ecommerce.validation.validators.UniqueEmailValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "Email is already in use";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
