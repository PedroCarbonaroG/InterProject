package com.interchallange.studyplan.api.response.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOrderResponse {

    @Schema(description = "Customer full name")
    private String name;

    @Schema(description = "Customer full email")
    private String email;

    @Schema(description = "Customer phone number")
    private String phoneNumber;

    @Schema(description = "All customer orders")
    private List<OrderResponse> orders;

}
