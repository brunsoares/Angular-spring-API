package com.brunsoares.crud_spring.enums.validation;

import com.brunsoares.crud_spring.enums.Category;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, CharSequence> {

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return Category.fromDescription(value.toString()) != null;
    }
}
