package com.interchallange.studyplan.api.impl;

import com.interchallange.studyplan.api.IOrderAPI;
import com.interchallange.studyplan.api.response.order.CustomerOrderResponse;
import com.interchallange.studyplan.api.response.order.OrderResponse;
import com.interchallange.studyplan.domain.mapper.IOrderMapper;
import com.interchallange.studyplan.service.CustomerService;
import com.interchallange.studyplan.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderAPI implements IOrderAPI {

    private final OrderService orderService;
    private final CustomerService customerService;

    @Override
    public OrderResponse create(String customerId) {

        log.info("Creating new order for customerId: {}", customerId);
        var order = orderService.create(customerId);

        return IOrderMapper.INSTANCE.toOrderResponse(order);
    }

    @Override
    public void processOrder(String orderId) {

        log.info("Processing order: {}, waiting for payment", orderId);
        orderService.processOrder(orderId);
    }

    @Override
    public void cancelOrder(String orderId) {

        log.info("Canceling order: {}", orderId);
        orderService.cancelOrder(orderId);
    }

    @Override
    public CustomerOrderResponse listAllOrdersByCustomer(String customerId) {

        log.info("Listing all orders by customerId: {}", customerId);
        return orderService.listAllOrdersByCustomer(customerId);
    }

    @Override
    public void addProductToOrder(String orderId, String productId) {

        log.info("Adding product: {}, for order: {}", productId, orderId);
        orderService.addProduct(productId, orderId);
    }


}
