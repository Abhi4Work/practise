package com.abhi4work.receiptmanagementsystem.exception;

import com.abhi4work.receiptmanagementsystem.util.CustomResultCodes;
import org.springframework.http.HttpStatus;

public class ReceiptDataAccessException extends BaseException{
    public ReceiptDataAccessException(String message)
    {
        this(message, CustomResultCodes.RECEIPT_DAO_ERROR.getCode());
    }

    public ReceiptDataAccessException(String message, int code)
    {
        this(message, code, HttpStatus.PRECONDITION_FAILED);
    }

    public ReceiptDataAccessException(String resultMessage, int resultCode, HttpStatus httpStatus)
    {
        super(resultMessage, resultCode, httpStatus);
    }
}
