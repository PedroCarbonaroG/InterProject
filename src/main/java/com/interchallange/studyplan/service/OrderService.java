package com.interchallange.studyplan.service;

import com.interchallange.studyplan.api.response.order.CustomerOrderResponse;
import com.interchallange.studyplan.domain.entity.Order;
import com.interchallange.studyplan.domain.entity.Product;
import com.interchallange.studyplan.domain.mapper.ICustomerMapper;
import com.interchallange.studyplan.domain.mapper.IOrderMapper;
import com.interchallange.studyplan.repository.CustomerRepository;
import com.interchallange.studyplan.repository.OrderRepository;
import com.interchallange.studyplan.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerService;
    private final ProductRepository productRepository;

    public List<Order> findByCustomerId(String id) {
        return orderRepository.findByCustomerId(id);
    }

    public CustomerOrderResponse listAllOrdersByCustomer(String customerId) {

        var orders = orderRepository.listAllOrdersByCustomer(customerId);
        var orderResponseList = IOrderMapper.INSTANCE.toOrderResponseList(orders);

        var customer = customerService.findById(customerId);
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

}
