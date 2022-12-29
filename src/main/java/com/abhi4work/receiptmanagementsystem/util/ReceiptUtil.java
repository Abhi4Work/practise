package com.abhi4work.receiptmanagementsystem.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class ReceiptUtil {

    private static final Logger logger = LogManager.getLogger(ReceiptUtil.class);

    public Pageable performPaginationSorting(Integer pageNo, Integer pageSize, String sort) {

        logger.debug("Process for pagination sorting initiated...");

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        if (sort != null) {
            List<String> sortParams = Arrays.asList(sort.split("_"));

            String sortId = sortParams.get(0);
            String sortType = sortParams.get(1);
            if (sortId != null && !sortId.isEmpty()) {
                logger.debug("Checking if sortType is " + sortType);
                if (sortType.equals("asc")) {
                    pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Order.asc(sortId)));
                } else if (sortType.equals("desc")) {
                    pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Order.desc(sortId)));
                }
            }
        }

        logger.debug("Pagination sorting process completed successfully");
        return pageable;
    }
}
