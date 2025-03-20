package com.interchallange.studyplan.repository;

import com.interchallange.studyplan.domain.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
interface IOrderRepository extends MongoRepository<Order, String> {

    List<Order> findByCustomerId(String id);

}
