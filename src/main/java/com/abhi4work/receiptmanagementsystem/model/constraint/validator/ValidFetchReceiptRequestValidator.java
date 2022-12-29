package com.abhi4work.receiptmanagementsystem.model.constraint.validator;


import com.abhi4work.receiptmanagementsystem.model.constraint.ValidateFetchReceiptRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.util.Objects;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ValidFetchReceiptRequestValidator implements ConstraintValidator<ValidateFetchReceiptRequest, Object[]> {
    @Override
    public void initialize(ValidateFetchReceiptRequest constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext constraintValidatorContext) {
        String id = (String)value[0];

        return Objects.nonNull(id);
    }
}
