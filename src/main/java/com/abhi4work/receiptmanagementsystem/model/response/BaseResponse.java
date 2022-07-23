package com.abhi4work.receiptmanagementsystem.model.response;

import lombok.*;


public class BaseResponse
{
	private int resultCode;
	private String resultDescription;

	public BaseResponse() {
	}

	public BaseResponse(int resultCode, String resultDescription) {
		this.resultCode = resultCode;
		this.resultDescription = resultDescription;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}


}
