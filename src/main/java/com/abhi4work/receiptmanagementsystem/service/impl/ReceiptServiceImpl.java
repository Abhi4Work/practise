package com.abhi4work.receiptmanagementsystem.service.impl;

import com.abhi4work.receiptmanagementsystem.domain.Receipt;
import com.abhi4work.receiptmanagementsystem.model.response.ReceiptResponseModel;
import com.abhi4work.receiptmanagementsystem.repository.ReceiptRepository;
import com.abhi4work.receiptmanagementsystem.service.ReceiptService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private static final Logger logger = LogManager.getLogger(ReceiptServiceImpl.class);

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public void createNewReceipt(Receipt receipt) throws Exception{
            receiptRepository.save(receipt);
    }
}
