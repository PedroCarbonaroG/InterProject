package com.interchallange.studyplan.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Payment Environment API")
@RequestMapping(value = "/payment", produces = MediaType.APPLICATION_JSON_VALUE)
public interface IPaymentAPI {

    @PostMapping
    void getOrderPayment(@RequestHeader String orderId);

}
