package com.interchallange.studyplan.service;

import com.interchallange.studyplan.domain.entity.Order;
import com.interchallange.studyplan.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> findOrdersByCustomerEmail(String email) {
        return orderRepository.findOrdersByCustomerEmail(email);
    }

}
