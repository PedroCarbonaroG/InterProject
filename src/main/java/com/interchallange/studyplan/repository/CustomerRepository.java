package com.interchallange.studyplan.repository;

import com.interchallange.studyplan.domain.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepository extends BaseRepository {

    private final ICustomerRepository repository;

    public Page<Customer> listAll(Pageable pageRequest) {
        return toPage(new Query(), pageRequest, Customer.class);
    }

    public void saveAll(List<Customer> customers) {
        repository.saveAll(customers);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

}
