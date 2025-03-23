package com.interchallange.studyplan.api.impl;

import com.interchallange.studyplan.api.IPaymentAPI;
import com.interchallange.studyplan.domain.enums.OrderStatus;
import com.interchallange.studyplan.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PaymentAPI implements IPaymentAPI {

    private final OrderService orderService;

    @Override
    public void getOrderPayment(String orderId) {
        var order = orderService.findById(orderId);
        order.setStatus(OrderStatus.FINISHED);
        orderService.finishOrder(order);
    }

}
