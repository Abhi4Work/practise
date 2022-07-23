package com.abhi4work.receiptmanagementsystem.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptRequestModel
{
	@JsonProperty("receipt")
	private ReceiptModel receipt = null;

	public ReceiptRequestModel workflow(ReceiptModel receipt) {
		this.receipt = receipt;
		return this;
	}

	@Valid
	public ReceiptModel getReceipt() {
		return receipt;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReceiptRequestModel {\n");

		sb.append("    receipt: ").append(toIndentedString(receipt)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
