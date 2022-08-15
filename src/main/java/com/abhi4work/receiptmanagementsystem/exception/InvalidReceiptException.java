package com.abhi4work.receiptmanagementsystem.exception;

import com.abhi4work.receiptmanagementsystem.util.CustomResultCodes;
import org.springframework.http.HttpStatus;

public class InvalidReceiptException extends BaseException{
    public InvalidReceiptException(String message)
    {
        this(message, CustomResultCodes.RECEIPT_DAO_ERROR.getCode());
    }

    public InvalidReceiptException(String message, int code)
    {
        this(message, code, HttpStatus.PRECONDITION_FAILED);
    }

    public InvalidReceiptException(String resultMessage, int resultCode, HttpStatus httpStatus)
    {
        super(resultMessage, resultCode, httpStatus);
    }
}
