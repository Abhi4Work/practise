package com.abhi4work.receiptmanagementsystem.controller.api;

import com.abhi4work.receiptmanagementsystem.model.request.ReceiptRequestModel;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptResponseModel;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public interface ReceiptAPI
{

//	@Operation(summary = "create a new Receipt", description = "", tags={ "receipt" })
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ReceiptRequestModel.class))),
//
//			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ReceiptRequestModel.class))) })
	@RequestMapping(value = "/receipt",
			produces = { "application/json" },
			consumes = { "application/json" },
			method = RequestMethod.POST)
	ResponseEntity<ReceiptResponseModel> createReceipt(
			@Parameter(in = ParameterIn.DEFAULT, description = "create a new receipt object in the system", required=true, schema=@Schema( implementation = ReceiptRequestModel.class)) @Valid @RequestBody ReceiptRequestModel body);
}
