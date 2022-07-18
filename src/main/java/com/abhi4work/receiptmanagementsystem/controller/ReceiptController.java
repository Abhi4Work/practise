package com.abhi4work.receiptmanagementsystem.controller;

import com.abhi4work.receiptmanagementsystem.controller.api.ReceiptAPI;
import com.abhi4work.receiptmanagementsystem.handlers.ReceiptRequestHandler;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class ReceiptController implements ReceiptAPI
{
	@Autowired
	private ReceiptRequestHandler requestHandler;

	@Override
	public ResponseEntity<ReceiptRequestModel> createReceipt(ReceiptRequestModel body)
	{
		return null;
	}
}
