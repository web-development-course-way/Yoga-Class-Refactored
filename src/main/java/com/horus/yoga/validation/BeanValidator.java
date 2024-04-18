package com.horus.yoga.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

import java.util.Set;

public class BeanValidator {

    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private BeanValidator() {
    }

    public static <T> void validate(T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

}
