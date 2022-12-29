package com.abhi4work.receiptmanagementsystem.model.constraint.validator;


import com.abhi4work.receiptmanagementsystem.constant.ReceiptConstants;
import com.abhi4work.receiptmanagementsystem.model.constraint.ValidateUpdateReceiptRequest;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptModel;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptRequestModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.util.Objects;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ValidUpdateReceiptRequestValidator implements ConstraintValidator<ValidateUpdateReceiptRequest, Object[]> {
    @Override
    public void initialize(ValidateUpdateReceiptRequest constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object[] value, ConstraintValidatorContext constraintValidatorContext) {
        ReceiptRequestModel receiptRequestModel = (ReceiptRequestModel)value[0];

        if(receiptRequestModel == null){
            return false;
        }
        ReceiptModel receiptModel = receiptRequestModel.getReceipt();

        return isValid(receiptModel);
    }

    private static boolean isValid(ReceiptModel receiptModel){
        return Objects.nonNull(receiptModel) &&
                Objects.nonNull(receiptModel.getId()) &&
                Objects.nonNull(receiptModel.getName()) &&
                Objects.nonNull(receiptModel.getAddress()) &&
                Objects.nonNull( receiptModel.getDescription()) &&
                receiptModel.getTotal() >= ReceiptConstants.ZERO &&
                receiptModel.getCash() >= ReceiptConstants.ZERO &&
                receiptModel.getChange() >= ReceiptConstants.ZERO ;
    }
}
