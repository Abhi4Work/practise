package com.abhi4work.receiptmanagementsystem.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Builder
@Getter
@Setter
public class ReceiptModel
{
	@JsonProperty(value = "id",access = JsonProperty.Access.READ_ONLY)
	private String id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("address")
	private String address;
	@JsonProperty("type")
	private String type;
	@JsonProperty("description")
	private List<ItemModel> description;
	@JsonProperty("total")
	private double total;
	@JsonProperty("cash")
	private double cash;
	@JsonProperty("change")
	private double change;

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ReceiptModel receiptModel = (ReceiptModel) o;
		return Objects.equals(this.id, receiptModel.id) &&
				Objects.equals(this.name, receiptModel.name) &&
				Objects.equals(this.address, receiptModel.address) &&
				Objects.equals(this.type, receiptModel.type) &&
				Objects.equals(this.description, receiptModel.description) &&
				Objects.equals(this.total, receiptModel.total) &&
				Objects.equals(this.cash, receiptModel.cash) &&
				Objects.equals(this.change, receiptModel.change) &&
				super.equals(o);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ReceiptModel {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    address: ").append(toIndentedString(address)).append("\n");
		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    receipt: ").append(toIndentedString(description)).append("\n");
		sb.append("    total: ").append(toIndentedString(total)).append("\n");
		sb.append("    cash: ").append(toIndentedString(cash)).append("\n");
		sb.append("    change: ").append(toIndentedString(change)).append("\n");
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
