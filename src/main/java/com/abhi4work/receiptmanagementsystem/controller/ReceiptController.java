package com.abhi4work.receiptmanagementsystem.controller;

import com.abhi4work.receiptmanagementsystem.controller.api.ReceiptAPI;
import com.abhi4work.receiptmanagementsystem.handlers.ReceiptRequestHandler;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptRequestModel;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptResponseModel;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptsResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class ReceiptController implements ReceiptAPI
{
	private static final Logger logger = LogManager.getLogger(ReceiptController.class);

	@Autowired
	private ReceiptRequestHandler requestHandler;

	@Override
	public String home() {
		return "This is Foogle Home";
	}

	@Override
	public ResponseEntity<ReceiptResponseModel> createReceipt(ReceiptRequestModel body)
	{
		logger.debug("Received new Receipt Create Request " + body.toString());
		ReceiptResponseModel receiptResponseModel = requestHandler.createANewReceipt(body);
		return ResponseEntity.ok(receiptResponseModel);
	}

	@Override
	public ResponseEntity<ReceiptResponseModel> updateReceipt(@Valid ReceiptRequestModel body) {

		logger.debug("Received new Receipt update Request " + body.toString());
		ReceiptResponseModel receiptResponseModel = requestHandler.updateAnExistingReceipt(body);
		return ResponseEntity.ok(receiptResponseModel);
	}

	@Override
	public ResponseEntity<ReceiptResponseModel> getReceiptById(String id) {
		logger.debug("Received new Receipt fetch Request " + id);
		ReceiptResponseModel receiptResponseModel = requestHandler.fetchAnExistingReceiptById(id);
		return ResponseEntity.ok(receiptResponseModel);
	}

	@Override
	public ResponseEntity<ReceiptsResponseModel> getAllReceiptsWithCriteria(String pageSize, String pageNum, String filter, String sort) {
		logger.debug("Received new Receipt fetch all Request " );
		ReceiptsResponseModel receiptsResponseModel = requestHandler.fetchAllReceipts(pageSize,pageNum,filter,sort);
		return ResponseEntity.ok(receiptsResponseModel);
	}

	@Override
	public ResponseEntity<ReceiptResponseModel> deleteReceipt(String id) {
		logger.debug("Received new Receipt fetch Request " + id);
		ReceiptResponseModel receiptResponseModel = requestHandler.deleteAnExistingReceipt(id);
		return ResponseEntity.ok(receiptResponseModel);
	}
}
