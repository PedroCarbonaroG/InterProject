package com.interchallange.studyplan.api.request.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    @Schema(description = "Customer full name")
    private String name;

    @Schema(description = "Customer full unique email")
    private String email;

    @Schema(description = "Customer full phone number. " +
            "Ex.: 11 digits-> (XX) X XXXX-XXXX " +
            "Just type digits")
    private String phoneNumber;

}
