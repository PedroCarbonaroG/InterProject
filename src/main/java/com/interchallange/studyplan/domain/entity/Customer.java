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
@Document(value = "Customer")
public class Customer {

    @Id
    @Description("Customer unique Identifier")
    private String id;

    @Description("Customer full name")
    private String name;

    @Description("Customer full email")
    private String email;

    @Description("Customer phone number")
    private String phoneNumber;

}
