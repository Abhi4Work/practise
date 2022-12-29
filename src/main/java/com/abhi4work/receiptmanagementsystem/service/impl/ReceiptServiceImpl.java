package com.abhi4work.receiptmanagementsystem.service.impl;

import com.abhi4work.receiptmanagementsystem.domain.Receipt;
import com.abhi4work.receiptmanagementsystem.repository.ReceiptRepository;
import com.abhi4work.receiptmanagementsystem.service.ReceiptService;
import com.abhi4work.receiptmanagementsystem.specifications.ReceiptSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    private static final Logger logger = LogManager.getLogger(ReceiptServiceImpl.class);

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public Receipt createNewReceipt(Receipt receipt) throws Exception{
          return  receiptRepository.save(receipt);
    }

    @Override
    @Transactional
    public Receipt updateExistingReceipt(Receipt receipt) throws Exception {
        return  receiptRepository.save(receipt);
    }

    @Override
    public Receipt retrieveReceipt(String id) {
        Optional<Receipt> receiptOptional = receiptRepository.findById(id);
        AtomicReference<Receipt> receipt = new AtomicReference<>();
        receiptOptional.ifPresent(s-> receipt.set(s));
        return receipt.get();
    }

    @Override
    public Page<Receipt> retrieveAllReceipts(ReceiptSpecification specification, Pageable pageable) {
        return receiptRepository.findAll(specification,pageable);
    }

    @Override
    public boolean doesReceiptExist(String id) {
        return receiptRepository.existsById(id);
    }

    @Override
    @Transactional
    public void deleteReceipt(String id) {
        receiptRepository.deleteById(id);
    }
}
