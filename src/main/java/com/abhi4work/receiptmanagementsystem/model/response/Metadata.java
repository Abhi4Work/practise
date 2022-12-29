package com.abhi4work.receiptmanagementsystem.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Metadata {
    private long page;
    private long nextPage;
    private long pageSize;
    private long pageCount;
    private long totalCount;
}
