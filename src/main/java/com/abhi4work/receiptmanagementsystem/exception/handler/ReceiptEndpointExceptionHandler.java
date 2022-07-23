package com.abhi4work.receiptmanagementsystem.exception.handler;

import com.abhi4work.receiptmanagementsystem.exception.ReceiptValidationException;
import com.abhi4work.receiptmanagementsystem.model.response.BaseResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ReceiptEndpointExceptionHandler
{
	private static final Logger logger = LogManager.getLogger(ReceiptEndpointExceptionHandler.class);

	public ResponseEntity<BaseResponse> getBaseResponse(){
		BaseResponse response = new BaseResponse();
		response.setResultCode(HttpStatus.NO_CONTENT.value());
		response.setResultDescription(HttpStatus.NO_CONTENT.getReasonPhrase());
		return ResponseEntity.ok(response);
	}

	@ExceptionHandler(ReceiptValidationException.class)
	public ResponseEntity<BaseResponse> handleReceiptValidationException(ReceiptValidationException receiptValidationException){
		return getBaseResponse();
	}
}
