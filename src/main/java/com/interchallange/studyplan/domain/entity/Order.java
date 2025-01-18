package com.interchallange.studyplan.domain.entity;

import com.interchallange.studyplan.domain.enums.OrderStatus;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "Order")
public class Order {

    @Id
    @Description("Order unique Identifier")
    private String id;

    @Description("Customer related to the order")
    private Customer customer;

    @Description("Effective date that order was made")
    private LocalDateTime orderDate;

    @Description("Order actual status")
    private OrderStatus status;

    @Description("Order total value")
    private Double orderValue;

    @Description("All order products")
    private List<Product> products;

}
