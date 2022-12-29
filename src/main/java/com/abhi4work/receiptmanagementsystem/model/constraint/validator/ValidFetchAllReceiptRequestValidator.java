package com.abhi4work.receiptmanagementsystem.model.constraint.validator;


import com.abhi4work.receiptmanagementsystem.model.constraint.ValidateFetchAllReceiptRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.util.Objects;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ValidFetchAllReceiptRequestValidator implements ConstraintValidator<ValidateFetchAllReceiptRequest, Object[]> {
    @Override
    public void initialize(ValidateFetchAllReceiptRequest constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext constraintValidatorContext) {
        Integer pageSize = (Integer)value[0];
        Integer pageNum = (Integer)value[1];

        return Objects.nonNull(pageSize) &&
                Objects.nonNull(pageNum) &&
                pageSize > 0 &&
                pageNum >= 0;
    }
}
