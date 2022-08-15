package com.abhi4work.receiptmanagementsystem.model.constraint;

import com.abhi4work.receiptmanagementsystem.model.constraint.validator.ValidDeleteReceiptRequestValidator;

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
@Constraint(validatedBy = ValidDeleteReceiptRequestValidator.class)
public @interface ValidateDeleteReceiptRequest {
    String message() default "Invalid create receipt request";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
