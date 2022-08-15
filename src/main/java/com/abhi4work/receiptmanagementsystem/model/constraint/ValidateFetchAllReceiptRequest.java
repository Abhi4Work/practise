package com.abhi4work.receiptmanagementsystem.model.constraint;

import com.abhi4work.receiptmanagementsystem.model.constraint.validator.ValidFetchAllReceiptRequestValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ ElementType.METHOD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValidFetchAllReceiptRequestValidator.class)
public @interface ValidateFetchAllReceiptRequest {
    String message() default "Invalid create receipt request";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}