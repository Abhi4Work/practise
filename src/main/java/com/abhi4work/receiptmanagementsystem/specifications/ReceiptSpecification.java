package com.abhi4work.receiptmanagementsystem.specifications;

import com.abhi4work.receiptmanagementsystem.domain.Receipt;
import com.abhi4work.receiptmanagementsystem.util.JsonUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptSpecification implements Specification<Receipt> {

    private String filter;

    @Override
    public Predicate toPredicate(Root<Receipt> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();


        if (filter != null && !filter.isEmpty()) {

            JsonArray jsonArray = JsonUtil.fromJson(filter, JsonArray.class);

            for (JsonElement json : jsonArray) {

                String filterId = json.getAsJsonObject().get("key").getAsString();

                if (filterId.equalsIgnoreCase("id"))

                    filterId = "id";

                String filterType = json.getAsJsonObject().get("operator").getAsString();

                String filterValue = json.getAsJsonObject().get("value").getAsString();

                if (!filterValue.isEmpty()) {


                    String filterVal = filterValue;


                    if (filterType.equals("contains")) {

                        filterVal = "%" + filterValue + "%";

                    } else if (filterType.equals("startsWith")) {

                        filterVal = filterValue + "%";

                    } else if (filterType.equals("endsWith")) {

                        filterVal = "%" + filterValue;

                    }


                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get(filterId).as(String.class), filterVal)));

                }

            }

        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));

    }

}
