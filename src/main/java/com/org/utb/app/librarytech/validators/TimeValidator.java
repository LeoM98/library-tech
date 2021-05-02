package com.org.utb.app.librarytech.validators;

import com.org.utb.app.librarytech.validators.annotations.TimeConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TimeValidator implements ConstraintValidator<TimeConstraint, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {

        return value <= 2021;
    }
}
