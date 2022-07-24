package com.abhi4work.receiptmanagementsystem.model.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse
{
	private int resultCode;
	private String resultMessage;
}
