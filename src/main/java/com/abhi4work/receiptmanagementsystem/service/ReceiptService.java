package com.abhi4work.receiptmanagementsystem.service;

import com.abhi4work.receiptmanagementsystem.domain.Receipt;
import com.abhi4work.receiptmanagementsystem.specifications.ReceiptSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReceiptService {
     Receipt createNewReceipt(Receipt receipt) throws Exception;
     Receipt updateExistingReceipt(Receipt receipt) throws Exception;
     Receipt retrieveReceipt(String id);
     Page<Receipt> retrieveAllReceipts(ReceiptSpecification specification, Pageable pageable);
     boolean doesReceiptExist(String id);
     void deleteReceipt(String id);
}
