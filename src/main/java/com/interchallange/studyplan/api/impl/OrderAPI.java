package com.interchallange.studyplan.api.impl;

import com.interchallange.studyplan.api.IOrderAPI;
import com.interchallange.studyplan.api.response.order.CustomerOrderResponse;
import com.interchallange.studyplan.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderAPI implements IOrderAPI {

    private final OrderService orderService;

    @Override
    public CustomerOrderResponse listAllOrdersByCustomer(String customerId) {
        return orderService.listAllOrdersByCustomer(customerId);
    }

    @Override
    public void addProductToOrder(String orderId, String productId) {
        orderService.addProduct(productId, orderId);
    }


}
