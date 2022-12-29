package com.abhi4work.receiptmanagementsystem.mapper;

import com.abhi4work.receiptmanagementsystem.domain.Receipt;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptModel;
import com.abhi4work.receiptmanagementsystem.util.JsonUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" , imports = {JsonUtil.class})
public interface ReceiptMapper {

    @Mapping(target = "id" , source = "id")
    @Mapping(target = "name" , source = "requestModel.name")
    @Mapping(target = "address" , source = "requestModel.address")
    @Mapping(target = "type" , source = "requestModel.type")
    @Mapping(target = "description" , expression = "java(JsonUtil.toJson(requestModel.getDescription()))")
    @Mapping(target = "total" , source = "requestModel.total")
    @Mapping(target = "cash" , source = "requestModel.cash")
    @Mapping(target = "change" , source = "requestModel.change")
    Receipt toReceiptFromReceiptRequestModel(ReceiptModel requestModel, String id);

    @Mapping(target = "description" , expression = "java(JsonUtil.fromJsonStringToPojoList(receipt.getDescription()))")
    ReceiptModel toReceiptModelFromReceipt(Receipt receipt);

    @Mapping(target = "description" , expression = "java(JsonUtil.toJson(receipt.getDescription()))")
    Receipt toReceiptFromReceiptRequestModel(ReceiptModel receipt);
}
