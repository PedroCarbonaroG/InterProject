package com.interchallange.studyplan.repository;

import com.interchallange.studyplan.domain.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository extends BaseRepository {

    private final IOrderRepository repository;

    private static final String CUSTOMER_ID = "customerId";

    public Order create(Order order) {
        return repository.save(order);
    }

    public Order findById(String id) {
        return repository.findById(id).get();
    }

    public List<Order> findByCustomerId(String id) {
        return repository.findByCustomerId(id);
    }

    public List<Order> listAllOrdersByCustomer(String customerId) {
        return repository.findByCustomerId(customerId);
    }

    public Order save(Order order) {
        return repository.save(order);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void saveAll(Iterable<Order> orders) {
        repository.saveAll(orders);
    }

}
