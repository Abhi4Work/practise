package com.abhi4work.receiptmanagementsystem.model.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ErrorBaseResponse
{

	private int resultCode;
	private String resultMessage;

	public int getResultCode()
	{
		return resultCode;
	}

	public void setResultCode(int resultCode)
	{
		this.resultCode = resultCode;
	}

	public String getResultMessage()
	{
		return resultMessage;
	}

	public void setResultMessage(String resultMessage)
	{
		this.resultMessage = resultMessage;
	}

	@Override
	public String toString()
	{
		return "ErrorBaseResponse{" + "resultCode=" + resultCode + ", resultMessage='" + resultMessage + '\'' + '}';
	}
}
