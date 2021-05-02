package com.org.utb.app.librarytech.validators.annotations;

import com.org.utb.app.librarytech.validators.TimeValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TimeValidator.class)

public @interface TimeConstraint {

    String message() default "Time must be not greater than 2021";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
