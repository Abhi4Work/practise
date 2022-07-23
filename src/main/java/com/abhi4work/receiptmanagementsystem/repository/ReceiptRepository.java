package com.abhi4work.receiptmanagementsystem.repository;

import com.abhi4work.receiptmanagementsystem.domain.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt,String> {

}
