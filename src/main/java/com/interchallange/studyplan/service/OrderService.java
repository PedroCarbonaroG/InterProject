package com.interchallange.studyplan.service;

import com.interchallange.studyplan.api.response.order.CustomerOrderResponse;
import com.interchallange.studyplan.domain.entity.Order;
import com.interchallange.studyplan.domain.entity.Product;
import com.interchallange.studyplan.domain.enums.OrderStatus;
import com.interchallange.studyplan.domain.mapper.ICustomerMapper;
import com.interchallange.studyplan.domain.mapper.IOrderMapper;
import com.interchallange.studyplan.repository.CustomerRepository;
import com.interchallange.studyplan.repository.OrderRepository;
import com.interchallange.studyplan.repository.ProductRepository;
import com.interchallange.studyplan.service.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public Order create(String customerId) {

        if (Objects.isNull(customerRepository.findById(customerId))) {
            throw new ValidationException("Customer don't exist");
        }

        var order = createOrder(customerId);
        return orderRepository.create(order);
    }

    private Order createOrder(String customerId) {

        return Order
                .builder()
                .customerId(customerId)
                .orderDate(LocalDateTime.now())
                .status(OrderStatus.PENDANT)
                .totalValue(BigDecimal.ZERO.doubleValue())
                .products(List.of())
                .build();
    }

    public void processOrder(String orderId) {

        var order = orderRepository.findById(orderId);
        order.setStatus(OrderStatus.PROCESSING);
        if (hadDiscount(order)) {
            orderRepository.save(order);
        }
    }

    public void cancelOrder(String orderId) {

        var order = orderRepository.findById(orderId);

        if (isAbleToCancel(order)) {
            order.setStatus(OrderStatus.CANCELED);
            orderRepository.save(order);
        } else {
            throw new ValidationException("This order can't be canceled, is already paid or finished");
        }
    }

    private boolean isAbleToCancel(Order order) {

        return switch (order.getStatus()) {
            case OrderStatus.PENDANT, OrderStatus.PROCESSING -> true;
            default -> false;
        };
    }

    public void finishOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> findByCustomerId(String id) {
        return orderRepository.findByCustomerId(id);
    }

    public Order findById(String id) {
        return orderRepository.findById(id);
    }

    public CustomerOrderResponse listAllOrdersByCustomer(String customerId) {

        var orders = orderRepository.listAllOrdersByCustomer(customerId);
        var orderResponseList = IOrderMapper.INSTANCE.toOrderResponseList(orders);

        var customer = customerRepository.findById(customerId);
        var customerResponse = ICustomerMapper.INSTANCE.toCustomerResponse(customer);

        return IOrderMapper.INSTANCE.toCustomerOrderResponse(customerResponse, orderResponseList);
    }

    public void addProduct(String productId, String orderId) {

        var product = productRepository.findById(productId);
        var order = orderRepository.findById(orderId);
        order.getProducts().add(product);

        orderRepository.save(updateOrderTotalValue(order));
    }

    private Order updateOrderTotalValue(Order order) {
        order.setTotalValue(order.getProducts().stream().mapToDouble(Product::getValue).sum());
        return order;
    }

    private boolean hadDiscount(Order order) {
        if (order.getTotalValue() > 500) {
            order.setTotalValue(order.getTotalValue() * 0.9);
            return true;
        } else {
            return false;
        }
    }

}
