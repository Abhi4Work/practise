package com.abhi4work.receiptmanagementsystem.exception;

import com.abhi4work.receiptmanagementsystem.util.CustomResultCodes;
import org.springframework.http.HttpStatus;

public class ReceiptValidationException extends BaseException
{
	public ReceiptValidationException(String message)
	{
		this(message, CustomResultCodes.RECEIPT_VALIDATION_ERROR.getCode());
	}

	public ReceiptValidationException(String message, int code)
	{
		this(message, code, HttpStatus.PRECONDITION_FAILED);
	}

	public ReceiptValidationException(String resultMessage, int resultCode, HttpStatus httpStatus)
	{
		super(resultMessage, resultCode, httpStatus);
	}
}
