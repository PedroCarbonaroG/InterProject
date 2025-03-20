package com.interchallange.studyplan.api;

import com.interchallange.studyplan.api.response.order.CustomerOrderResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Order API - Order environment")
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public interface IOrderAPI {

    @GetMapping
    CustomerOrderResponse listAllOrdersByCustomer(@RequestHeader String customerId);

    @PostMapping("add-product")
    void addProductToOrder(@RequestHeader String orderId, @RequestHeader String productId);

}
