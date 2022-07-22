package com.abhi4work.receiptmanagementsystem.controller;

import com.abhi4work.receiptmanagementsystem.controller.api.ReceiptAPI;
import com.abhi4work.receiptmanagementsystem.handlers.ReceiptRequestHandler;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptRequestModel;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ReceiptController implements ReceiptAPI
{
	private static final Logger logger = LogManager.getLogger(ReceiptController.class);

	@Autowired
	private ReceiptRequestHandler requestHandler;

	@Override
	public ResponseEntity<ReceiptResponseModel> createReceipt(ReceiptRequestModel body)
	{
		logger.debug("Received new Receipt Create Request " + body.toString());
		ReceiptResponseModel receiptResponseModel = requestHandler.createANewReceipt(body);
		return ResponseEntity.ok(receiptResponseModel);
	}
}
