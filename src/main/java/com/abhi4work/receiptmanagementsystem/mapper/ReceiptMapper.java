package com.abhi4work.receiptmanagementsystem.mapper;

import com.abhi4work.receiptmanagementsystem.domain.Receipt;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ReceiptMapper {

    @Mapping(target = "id" , source = "id")
    @Mapping(target = "name" , source = "receiptRequestModel.receipt.name")
    @Mapping(target = "address" , source = "receiptRequestModel.receipt.address")
    @Mapping(target = "type" , source = "receiptRequestModel.receipt.type")
    @Mapping(target = "description" , source = "receiptRequestModel.receipt.description")
    @Mapping(target = "total" , source = "receiptRequestModel.receipt.total")
    @Mapping(target = "cash" , source = "receiptRequestModel.receipt.cash")
    @Mapping(target = "change" , source = "receiptRequestModel.receipt.change")
    Receipt toReceiptFromReceiptRequestModel(ReceiptRequestModel receiptRequestModel, String id);
}
