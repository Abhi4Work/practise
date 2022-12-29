package com.abhi4work.receiptmanagementsystem.model.response;

import com.abhi4work.receiptmanagementsystem.model.request.ReceiptModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class ReceiptResponseModel extends BaseResponse
{
	@JsonProperty("receipt")
	private ReceiptModel receipt = null;

	public ReceiptResponseModel receipt(ReceiptModel receipt) {
		this.receipt = receipt;
		return this;
	}

	public void setReceipt(ReceiptModel receipt) {
		this.receipt = receipt;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ReceiptResponseModel receiptResponse = (ReceiptResponseModel) o;
		return Objects.equals(this.receipt, receiptResponse.receipt) &&
				super.equals(o);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReceiptResponseModel {\n");

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

	@Builder(builderMethodName = "builderBase")
	public ReceiptResponseModel(ReceiptModel receipt, int resultCode, String resultMessage){
		super(resultCode,resultMessage);
		this.receipt = receipt;
	}
}
