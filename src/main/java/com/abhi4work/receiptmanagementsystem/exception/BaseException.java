package com.abhi4work.receiptmanagementsystem.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException
{

	private static final long serialVersionUID = 2827129787867408575L;

	private final int resultCode;
	private final HttpStatus httpCode;
	private String resultMessage;

	public BaseException(String resultMessage, int resultCode, HttpStatus httpCode)
	{
		super(resultMessage);
		this.resultCode = resultCode;
		this.httpCode = httpCode;
	}

	/**
	 * Gets code.
	 *
	 * @return the code
	 */
	public int getResultCode()
	{
		return resultCode;
	}

	/**
	 * Gets message.
	 *
	 * @return the message
	 */
	public String getResultMessage()
	{
		return resultMessage;
	}

	public HttpStatus getHttpCode()
	{
		return httpCode;
	}
}
