package com.abhi4work.receiptmanagementsystem.model.constraint.validator;


import com.abhi4work.receiptmanagementsystem.model.constraint.ValidateCreateReceiptRequest;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptModel;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptRequestModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ValidCreateReceiptRequestValidator implements ConstraintValidator<ValidateCreateReceiptRequest, Object[]> {
    @Override
    public void initialize(ValidateCreateReceiptRequest constraintAnnotation) {

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
        return receiptModel !=null &&
                receiptModel.getName()!= null &&
                receiptModel.getAddress()!=null &&
                receiptModel.getDescription()!=null &&
                receiptModel.getTotal()!= Double.NaN &&
                receiptModel.getCash()!= Double.NaN &&
                receiptModel.getChange() != Double.NaN ;
    }
}
