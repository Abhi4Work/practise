package com.abhi4work.receiptmanagementsystem.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse
{
	private int resultCode;
	private String resultMessage;
}
