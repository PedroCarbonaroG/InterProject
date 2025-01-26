package com.interchallange.studyplan.repository;

import com.interchallange.studyplan.domain.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ICustomerRepository extends MongoRepository<Customer, String> {
}
