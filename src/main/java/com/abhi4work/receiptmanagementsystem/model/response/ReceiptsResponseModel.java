package com.abhi4work.receiptmanagementsystem.model.response;

import com.abhi4work.receiptmanagementsystem.model.request.ReceiptModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
public class ReceiptsResponseModel extends BaseResponse
{
    @JsonProperty("receipts")
    private List<ReceiptModel> receipts = null;
    @JsonProperty("metadata")
    private Metadata metadata;

    public ReceiptsResponseModel receipts(List<ReceiptModel> receipts) {
        this.receipts = receipts;
        return this;
    }

    public void setReceipt(List<ReceiptModel> receipts) {
        this.receipts = receipts;
    }

    public ReceiptsResponseModel metadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReceiptsResponseModel receiptResponse = (ReceiptsResponseModel) o;
        return Objects.equals(this.receipts, receiptResponse.receipts) &&
                super.equals(o);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ReceiptResponseModel {\n");

        sb.append("    receipts: ").append(receipts.stream().map(this::toIndentedString).collect(Collectors.joining(",\n"))).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    @Builder(builderMethodName = "builderBase")
    public ReceiptsResponseModel(List<ReceiptModel> receipts,Metadata metadata, int resultCode, String resultMessage){
        super(resultCode,resultMessage);
        this.receipts = receipts;
        this.metadata = metadata;
    }
}
