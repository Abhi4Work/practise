package com.abhi4work.receiptmanagementsystem.mapper;

import com.abhi4work.receiptmanagementsystem.domain.Receipt;
import com.abhi4work.receiptmanagementsystem.model.request.ReceiptModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReceiptMapper {

    @Mapping(target = "id" , source = "id")
    @Mapping(target = "name" , source = "requestModel.name")
    @Mapping(target = "address" , source = "requestModel.address")
    @Mapping(target = "type" , source = "requestModel.type")
    @Mapping(target = "description" , ignore=true)
    @Mapping(target = "total" , source = "requestModel.total")
    @Mapping(target = "cash" , source = "requestModel.cash")
    @Mapping(target = "change" , source = "requestModel.change")
    Receipt toReceiptFromReceiptRequestModel(ReceiptModel requestModel, String id);
}
