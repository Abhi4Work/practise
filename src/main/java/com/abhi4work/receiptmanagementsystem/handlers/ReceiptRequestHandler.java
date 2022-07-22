package com.abhi4work.receiptmanagementsystem.handlers;

import com.abhi4work.receiptmanagementsystem.model.request.ReceiptRequestModel;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Slf4j
@Validated
public class ReceiptRequestHandler
{
	public ReceiptResponseModel createANewReceipt(ReceiptRequestModel body)
	{

		return null;
	}
}
