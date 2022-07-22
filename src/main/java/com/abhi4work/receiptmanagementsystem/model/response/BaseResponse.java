package com.abhi4work.receiptmanagementsystem.model.response;

import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse
{
	private int resultCode;
	private String resultDescription;
}
