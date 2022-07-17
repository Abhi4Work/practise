package com.abhi4work.receiptmanagementsystem.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ErrorResponse extends ErrorBaseResponse
{
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date timestamp;
	private String details;

	public ErrorResponse()
	{
		super();
	}
	public ErrorResponse(int resultCode, String resultMessage, Date timestamp, String details)
	{
		super(resultCode, resultMessage);
		this.timestamp = timestamp;
		this.details = details;
	}

	public ErrorResponse(Date timestamp, String details)
	{
		this.timestamp = timestamp;
		this.details = details;
	}

	public Date getTimestamp()
	{
		return timestamp;
	}

	public void setTimestamp(Date timestamp)
	{
		this.timestamp = timestamp;
	}

	public String getDetails()
	{
		return details;
	}

	public void setDetails(String details)
	{
		this.details = details;
	}
}
