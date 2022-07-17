package com.abhi4work.receiptmanagementsystem.controller;

import com.abhi4work.receiptmanagementsystem.controller.api.ReceiptAPI;
import com.abhi4work.receiptmanagementsystem.handlers.ReceiptRequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class ReceiptController implements ReceiptAPI
{
	@Autowired
	private ReceiptRequestHandler requestHandler;
	@Override
	public ResponseEntity<Object> createReceipt(Object body)
	{
		return null;
	}
}
