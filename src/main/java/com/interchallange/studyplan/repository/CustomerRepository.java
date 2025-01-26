package com.interchallange.studyplan.repository;

import com.interchallange.studyplan.domain.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomerRepository extends BaseRepository {

    private final ICustomerRepository repository;

    public Page<Customer> listAll(Pageable pageRequest) {
        return toPage(new Query(), pageRequest, Customer.class);
    }

}
