package com.abhi4work.receiptmanagementsystem.exception.handler;

import com.abhi4work.receiptmanagementsystem.model.response.ErrorResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.Date;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DefaultExceptionHandler
{
	private static final Logger logger = LogManager.getLogger(DefaultExceptionHandler.class);
	private String stackTraceString = "";

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleDefaultExceptions(Exception ex, WebRequest request)
	{
		Arrays.asList(ex.getCause().getStackTrace()).forEach(s -> {
			stackTraceString += s + "\n ";
		});

		logger.error(ex.getMessage() + "\n" + stackTraceString, ex);

		ErrorResponse errorResponse = new ErrorResponse(
				HttpStatus.UNAUTHORIZED.value(),
				ex.getMessage(),new Date(),
				request.getDescription(false));
		return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
	}
}
