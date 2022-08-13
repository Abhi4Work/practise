package com.abhi4work.receiptmanagementsystem.controller.api;

import com.abhi4work.receiptmanagementsystem.model.request.ReceiptRequestModel;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptResponseModel;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptsResponseModel;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface ReceiptAPI
{

//	@Operation(summary = "create a new Receipt", description = "", tags={ "receipt" })
//	@ApiResponses(value = {
//			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = ReceiptRequestModel.class))),
//
//			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ReceiptRequestModel.class))) })
	@RequestMapping(value = "/home",
			produces = { "application/json" },
			method = RequestMethod.GET)
	String home();

	@RequestMapping(value = "/receipt",
			produces = { "application/json" },
			consumes = { "application/json" },
			method = RequestMethod.POST)
	ResponseEntity<ReceiptResponseModel> createReceipt(
			@Parameter(in = ParameterIn.DEFAULT, description = "create a new receipt object in the system", required=true, schema=@Schema( implementation = ReceiptRequestModel.class)) @Valid @RequestBody ReceiptRequestModel body);

	@RequestMapping(value = "/receipt",
			produces = { "application/json" },
			consumes = { "application/json" },
			method = RequestMethod.PUT)
	ResponseEntity<ReceiptResponseModel> updateReceipt(
			@Parameter(in = ParameterIn.DEFAULT, description = "update receipt object in the system", required=true, schema=@Schema( implementation = ReceiptRequestModel.class)) @Valid @RequestBody ReceiptRequestModel body);

	@RequestMapping(value = "/receipt/{id}",
			produces = { "application/json" },
			method = RequestMethod.GET)
	ResponseEntity<ReceiptResponseModel> getReceiptById(
			@Parameter(in = ParameterIn.PATH, description = "id to fetch receipt object in the system", required=true, schema=@Schema( implementation = String.class)) @PathVariable String id);

	@RequestMapping(value = "/receipt",
			produces = { "application/json" },
			method = RequestMethod.GET)
	ResponseEntity<ReceiptsResponseModel> getAllReceiptsWithCriteria(
			@Parameter(in = ParameterIn.QUERY, description = "perPage", required=true, schema=@Schema( implementation = String.class)) @RequestParam String pageSize,
			@Parameter(in = ParameterIn.QUERY, description = "page", required=true, schema=@Schema( implementation = String.class)) @RequestParam String pageNum,
			@Parameter(in = ParameterIn.QUERY, description = "filter", required=true, schema=@Schema( implementation = String.class)) @RequestParam String filter,
			@Parameter(in = ParameterIn.QUERY, description = "sort", required=true, schema=@Schema( implementation = String.class)) @RequestParam(defaultValue = "id_desc") String sort);

	@RequestMapping(value = "/receipt",
			produces = { "application/json" },
			consumes = { "application/json" },
			method = RequestMethod.DELETE)
	ResponseEntity<ReceiptResponseModel> deleteReceipt(
			@Parameter(in = ParameterIn.PATH, description = "id of receipt object to delete from the system", required=true, schema=@Schema( implementation = String.class)) @PathVariable String id);

}
