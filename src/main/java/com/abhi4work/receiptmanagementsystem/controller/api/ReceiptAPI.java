package com.abhi4work.receiptmanagementsystem.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ReceiptAPI
{

	@Operation(summary = "create a new Receipt", description = "", tags={ "receipt" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Object.class))),

			@ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = Object.class))) })
	@RequestMapping(value = "/receipt",
			produces = { "application/json" },
			consumes = { "application/json" },
			method = RequestMethod.POST)
	ResponseEntity<Object> createReceipt(
			@Parameter(in = ParameterIn.DEFAULT, description = "create a new receipt object in the system", required=true, schema=@Schema()) @RequestBody Object body);
}
