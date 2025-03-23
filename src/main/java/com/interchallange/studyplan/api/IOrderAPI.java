package com.interchallange.studyplan.api;

import com.interchallange.studyplan.api.response.order.CustomerOrderResponse;
import com.interchallange.studyplan.api.response.order.OrderResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Order environment API")
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public interface IOrderAPI {

    @PostMapping
    OrderResponse create(@RequestHeader String customerId);

    @PostMapping("/process")
    void processOrder(@RequestHeader String orderId);

    @PostMapping("/cancel")
    void cancelOrder(@RequestHeader String orderId);

    @GetMapping
    CustomerOrderResponse listAllOrdersByCustomer(@RequestHeader String customerId);

    @PostMapping("add-product")
    void addProductToOrder(@RequestHeader String orderId, @RequestHeader String productId);

}
