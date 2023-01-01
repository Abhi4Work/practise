package com.abhi4work.receiptmanagementsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
//@Table
public class Receipt {

    @Id
    private String id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "address")
    private String address;

//    @Column(name = "type")
    private String type;

//    @Column(name = "description" , columnDefinition = "LONGTEXT")
    private String description;

//    @Column(name = "total")
    private double total;

//    @Column(name = "cash")
    private double cash;

//    @Column(name = "change")
    private double change;

//    @Override
//    public boolean equals(java.lang.Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Receipt receipt = (Receipt) o;
//        return Objects.equals(this.id, receipt.id) &&
//                Objects.equals(this.name, receipt.name) &&
//                Objects.equals(this.address, receipt.address) &&
//                Objects.equals(this.type, receipt.type) &&
//                Objects.equals(this.description, receipt.description) &&
//                Objects.equals(this.total, receipt.total) &&
//                Objects.equals(this.cash, receipt.cash) &&
//                Objects.equals(this.change, receipt.change) &&
//                super.equals(o);
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("class Receipt {\n");
//        sb.append("    id: ").append(toIndentedString(id)).append("\n");
//        sb.append("    name: ").append(toIndentedString(name)).append("\n");
//        sb.append("    address: ").append(toIndentedString(address)).append("\n");
//        sb.append("    type: ").append(toIndentedString(type)).append("\n");
//        sb.append("    receipt: ").append(toIndentedString(description)).append("\n");
//        sb.append("    total: ").append(toIndentedString(total)).append("\n");
//        sb.append("    cash: ").append(toIndentedString(cash)).append("\n");
//        sb.append("    change: ").append(toIndentedString(change)).append("\n");
//        sb.append("    description: ").append(toIndentedString(description)).append("\n");
//        sb.append("}");
//        return sb.toString();
//    }
//
//    private String toIndentedString(Object o) {
//        if (o == null) {
//            return "null";
//        }
//        return o.toString().replace("\n", "\n    ");
//    }
//
//
//

}
