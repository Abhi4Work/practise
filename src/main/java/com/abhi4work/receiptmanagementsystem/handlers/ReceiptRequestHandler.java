package com.abhi4work.receiptmanagementsystem.handlers;

import com.abhi4work.receiptmanagementsystem.model.request.ReceiptRequestModel;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptResponseModel;
import com.abhi4work.receiptmanagementsystem.repository.ReceiptRepository;
import com.abhi4work.receiptmanagementsystem.service.ReceiptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Slf4j
@Validated
public class ReceiptRequestHandler
{
	private static final Logger logger = LogManager.getLogger(ReceiptRequestHandler.class);

	@Autowired
	private ReceiptService receiptService;

	public ReceiptResponseModel createANewReceipt(ReceiptRequestModel body)
	{

		return null;
	}
}
