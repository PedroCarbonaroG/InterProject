package com.interchallange.studyplan.api.response.order;

import com.interchallange.studyplan.api.response.product.ProductResponse;
import com.interchallange.studyplan.domain.enums.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    @Schema(description = "Order id")
    private String id;

    @Schema(description = "Effective date that order was made")
    private LocalDateTime orderDate;

    @Schema(description = "Order actual status")
    private OrderStatus status;

    @Schema(description = "Order total value")
    private Double totalValue;

    @Schema(description = "All order products")
    private List<ProductResponse> products;

}
