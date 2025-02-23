package com.interchallange.studyplan.repository;

import com.interchallange.studyplan.domain.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository extends BaseRepository {

    private final IOrderRepository repository;

    public List<Order> findOrdersByCustomerEmail(String email) {
        return repository.findByCustomerEmail(email);
    }

    public Order save(Order order) {
        return repository.save(order);
    }

}
