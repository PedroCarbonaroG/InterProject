package com.interchallange.studyplan.domain.entity;

import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "Product")
public class Product {

    @Id
    @Description("Product unique Identifier")
    private String id;

    @Description("Product description")
    private String description;

    @Description("Product market value")
    private Double value;

}
