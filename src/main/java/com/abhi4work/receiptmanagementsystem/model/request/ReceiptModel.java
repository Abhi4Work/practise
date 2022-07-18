package com.abhi4work.receiptmanagementsystem.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

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
}
