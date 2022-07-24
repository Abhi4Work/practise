package com.abhi4work.receiptmanagementsystem.handlers;

import com.abhi4work.receiptmanagementsystem.domain.Receipt;
import com.abhi4work.receiptmanagementsystem.mapper.ReceiptMapper;
import com.abhi4work.receiptmanagementsystem.model.constraint.ValidateCreateReceiptRequest;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptRequestModel;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptResponseModel;
import com.abhi4work.receiptmanagementsystem.repository.ReceiptRepository;
import com.abhi4work.receiptmanagementsystem.service.ReceiptService;
import com.abhi4work.receiptmanagementsystem.util.CustomResultCodes;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Slf4j
@Validated
public class ReceiptRequestHandler
{
	private static final Logger logger = LogManager.getLogger(ReceiptRequestHandler.class);

	@Autowired
	private ReceiptService receiptService;
	@Autowired
	private ReceiptMapper receiptMapper;

	@ValidateCreateReceiptRequest(message = "compulsory request params are invalid")
	public ReceiptResponseModel createANewReceipt(ReceiptRequestModel body)
	{
		String id = UUID.randomUUID().toString();
		Receipt receipt = receiptMapper.toReceiptFromReceiptRequestModel(body,id);
		try {
			receiptService.createNewReceipt(receipt);
		} catch (Exception exception) {
			logger.error("Error encountered while trying to create a new receipt \n" + receipt + "/n",exception);
			return ReceiptResponseModel.builderBase()
					.resultCode(CustomResultCodes.RECEIPT_CREATION_ERROR.getCode())
					.resultMessage(CustomResultCodes.RECEIPT_CREATION_ERROR.getReason())
					.build();
		}

		return ReceiptResponseModel.builderBase()
			.resultCode(CustomResultCodes.SUCCESSFUL.getCode())
			.resultMessage(CustomResultCodes.SUCCESSFUL.getReason())
			.build();
	}
}
