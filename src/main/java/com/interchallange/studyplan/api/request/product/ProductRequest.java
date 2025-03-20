package com.interchallange.studyplan.api.request.product;

import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    @Description("Product description")
    private String description;

    @Description("Product market value")
    private Double value;

}
