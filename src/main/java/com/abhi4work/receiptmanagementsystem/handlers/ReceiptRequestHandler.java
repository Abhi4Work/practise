package com.abhi4work.receiptmanagementsystem.handlers;

import com.abhi4work.receiptmanagementsystem.domain.Receipt;
import com.abhi4work.receiptmanagementsystem.exception.InvalidReceiptException;
import com.abhi4work.receiptmanagementsystem.mapper.ReceiptMapper;
import com.abhi4work.receiptmanagementsystem.model.constraint.*;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptModel;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptRequestModel;
import com.abhi4work.receiptmanagementsystem.model.response.Metadata;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptResponseModel;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptsResponseModel;
import com.abhi4work.receiptmanagementsystem.service.ReceiptService;
import com.abhi4work.receiptmanagementsystem.specifications.ReceiptSpecification;
import com.abhi4work.receiptmanagementsystem.util.CustomResultCodes;
import com.abhi4work.receiptmanagementsystem.util.JsonUtil;
import com.abhi4work.receiptmanagementsystem.util.ReceiptUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

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
	@Autowired
	private ReceiptUtil receiptUtil;

	@ValidateCreateReceiptRequest(message = "compulsory request params are invalid")
	public ReceiptResponseModel createANewReceipt(ReceiptRequestModel body)
	{
		String id = UUID.randomUUID().toString();
		Receipt receipt = receiptMapper.toReceiptFromReceiptRequestModel(body.getReceipt(),id);
		Receipt result = null;
		try {

			result = receiptService.createNewReceipt(receipt);
		} catch (Exception exception) {
			logger.error("Error encountered while trying to create a new receipt \n" + receipt + "/n",exception);
			return buildResponse(CustomResultCodes.RECEIPT_CREATION_ERROR,result,"");
		}
		return buildResponse(CustomResultCodes.SUCCESSFUL,result," in creating a new receipt.");
	}

	@ValidateUpdateReceiptRequest(message = "compulsory request params are invalid")
	public ReceiptResponseModel updateAnExistingReceipt(ReceiptRequestModel body)
	{
		Receipt receipt = receiptMapper.toReceiptFromReceiptRequestModel(body.getReceipt());
		receipt.setDescription(JsonUtil.toJson(body.getReceipt().getDescription()));
		Receipt result = null;
		try {

			result = receiptService.updateExistingReceipt(receipt);
		} catch (Exception exception) {
			logger.error("Error encountered while trying to update an existing receipt \n" + receipt + "/n",exception);
			return buildResponse(CustomResultCodes.RECEIPT_UPDATE_ERROR,result,"");
		}
		return buildResponse(CustomResultCodes.SUCCESSFUL,result," in updating existing receipt with id " + receipt.getId());
	}

	@ValidateFetchReceiptRequest(message = "compulsory request id is invalid")
	public ReceiptResponseModel fetchAnExistingReceiptById(String id)
	{
		Receipt receipt = null;
		try{
			receipt = receiptService.retrieveReceipt(id);
			if(!Objects.nonNull(receipt)){
				throw new InvalidReceiptException("Unable to find receipt with id " + id);
			}
		}catch (InvalidReceiptException invalidReceiptException){
			logger.error(invalidReceiptException.getResultMessage(),invalidReceiptException);
			return buildResponse(CustomResultCodes.RECEIPT_DAO_ERROR,receipt,"");
		}
		catch(Exception exception){
			logger.error(exception.getMessage(),exception);
			return buildResponse(CustomResultCodes.RECEIPT_FETCH_ERROR,receipt,"");
		}
		return buildResponse(CustomResultCodes.SUCCESSFUL,receipt, " in fetching an existing receipt with id " + id);
	}

	@ValidateFetchAllReceiptRequest(message = "compulsory request params are invalid")
	public ReceiptsResponseModel fetchAllReceipts(Integer pageSize, Integer pageNum,String filter,String sort)
	{
		Pageable pageable = receiptUtil.performPaginationSorting(pageNum,pageSize,sort);
		List<ReceiptModel> result = null;
		Page<Receipt> receiptPage = null;
		try{
			receiptPage = receiptService.retrieveAllReceipts(new ReceiptSpecification(filter),pageable);
			result = receiptPage.getContent().stream().map(receipt -> receiptMapper.toReceiptModelFromReceipt(receipt)).collect(Collectors.toList());;
		}catch (Exception exception){
			logger.error(exception.getMessage(),exception);
			return buildResponse(CustomResultCodes.RECEIPT_FETCH_ERROR,result,pageNum,pageSize,receiptPage,"");
		}
		return buildResponse(CustomResultCodes.SUCCESSFUL,result,pageNum,pageSize,receiptPage," in fetching all receipts.");
	}

	@ValidateDeleteReceiptRequest(message = "compulsory request id is invalid")
	public ReceiptResponseModel deleteAnExistingReceipt(String id)
	{
		try{
			if(!receiptService.doesReceiptExist(id)){
				throw new InvalidReceiptException("Unable to find receipt with id " + id);
			}
			receiptService.deleteReceipt(id);
		}catch (InvalidReceiptException invalidReceiptException){
			logger.error(invalidReceiptException.getResultMessage(),invalidReceiptException);
			return buildResponse(CustomResultCodes.RECEIPT_DAO_ERROR,null,"");
		}
		catch(Exception exception){
			logger.error(exception.getMessage(),exception);
			return buildResponse(CustomResultCodes.RECEIPT_DELETE_ERROR,null,"");
		}
		return buildResponse(CustomResultCodes.SUCCESSFUL,null," in deleting an existing receipt with id " + id);
	}

	private ReceiptResponseModel buildResponse(CustomResultCodes resultCode, Receipt receipt,String message){
		boolean receiptNotNull = Objects.nonNull(receipt);
		return ReceiptResponseModel.builderBase()
				.resultCode(resultCode.getCode())
				.resultMessage(resultCode.getReason() + message)
				.receipt(receiptNotNull ? receiptMapper.toReceiptModelFromReceipt(receipt) : null)
				.build();
	}

	private ReceiptsResponseModel buildResponse(CustomResultCodes resultCode, List<ReceiptModel> receiptModels,
												Integer pageNum,Integer pageSize,Page<Receipt> page,String message){
		boolean receiptNotNull = Objects.nonNull(receiptModels);
		boolean pageNotNull = Objects.nonNull(page);
		Metadata metadata = (pageNotNull && receiptNotNull) ? Metadata.builder().page(pageNum).pageSize(pageSize).pageCount(page.getTotalPages())
				.nextPage((pageNum + 1) >= page.getTotalPages() ? pageNum : (pageNum + 1))
				.totalCount(page.getTotalElements()).build() : null;
		return ReceiptsResponseModel.builderBase()
				.resultCode(resultCode.getCode())
				.resultMessage(resultCode.getReason() + message)
				.receipts(receiptNotNull ? receiptModels : null)
				.metadata(metadata)
				.build();
	}
}
