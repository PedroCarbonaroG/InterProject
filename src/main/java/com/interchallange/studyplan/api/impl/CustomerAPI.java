package com.interchallange.studyplan.api.impl;

import com.interchallange.studyplan.api.ICustomerAPI;
import com.interchallange.studyplan.api.request.CustomerRequest;
import com.interchallange.studyplan.api.response.PageResponse;
import com.interchallange.studyplan.api.response.customer.CustomerResponse;
import com.interchallange.studyplan.domain.mapper.ICustomerMapper;
import com.interchallange.studyplan.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CustomerAPI implements ICustomerAPI {

    private final CustomerService customerService;

    @Override
    public PageResponse<CustomerResponse> listAll(String name, Pageable pageRequest) {

        log.info("List all | Listing all customers in database");
        var pageCostumer = customerService.listAll(name, pageRequest);

        return ICustomerMapper.INSTANCE.toPageResponseCustomerResponse(pageCostumer);
    }

    @Override
    public CustomerResponse findById(String id) {

        log.info("Find by id | Finding customer by id: {}", id);
        var customer = customerService.findById(id);

        return ICustomerMapper.INSTANCE.toCustomerResponse(customer);
    }

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {

        log.info("Create | Creating new customer with email: {}", customerRequest.getEmail());
        var customerEntity = ICustomerMapper.INSTANCE.toCustomer(customerRequest);
        var createdCustomer = customerService.create(customerEntity);

        return ICustomerMapper.INSTANCE.toCustomerResponse(createdCustomer);
    }

    @Override
    public CustomerResponse update(String id, CustomerRequest customerRequest) {

        log.info("Update | Updating customer with id: {}", id);
        var customerEntity = ICustomerMapper.INSTANCE.toCustomer(customerRequest);
        var updatedCustomer = customerService.update(id, customerEntity);

        return ICustomerMapper.INSTANCE.toCustomerResponse(updatedCustomer);
    }

    @Override
    public void delete(String email) {

        log.info("Delete | Deleting customer by email: {}", email);
        customerService.delete(email);
    }



}
