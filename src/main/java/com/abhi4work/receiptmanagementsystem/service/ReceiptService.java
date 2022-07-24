package com.abhi4work.receiptmanagementsystem.service;

import com.abhi4work.receiptmanagementsystem.domain.Receipt;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptResponseModel;

public interface ReceiptService {
     void createNewReceipt(Receipt receipt) throws Exception;
}
