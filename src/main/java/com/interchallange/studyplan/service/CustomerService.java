package com.interchallange.studyplan.service;

import com.interchallange.studyplan.domain.entity.Customer;
import com.interchallange.studyplan.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Page<Customer> listAll(Pageable pageRequest) {
        return customerRepository.listAll(pageRequest);
    }

}
