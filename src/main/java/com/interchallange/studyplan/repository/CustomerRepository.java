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

    private static final String NAME_FIELD = "name";

    public Page<Customer> listAll(String filterByName, Pageable pageRequest) {

        Query query = new Query();

        addParamToQuery(query, NAME_FIELD, filterByName);

        return toPage(query, pageRequest, Customer.class);
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public void saveAll(List<Customer> customers) {
        repository.saveAll(customers);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public void delete(String email) {
        repository.deleteByEmail(email);
    }

    public Customer findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Customer findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Customer update(Customer customer) {
        return save(customer);
    }

}
