package com.interchallange.studyplan.api.impl;

import com.interchallange.studyplan.api.ICustomerAPI;
import com.interchallange.studyplan.api.request.PageRequestDTO;
import com.interchallange.studyplan.api.response.PageResponse;
import com.interchallange.studyplan.api.response.customer.CustomerResponse;
import com.interchallange.studyplan.domain.mapper.ICustomerMapper;
import com.interchallange.studyplan.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CustomerAPI implements ICustomerAPI {

    private final CustomerService customerService;

    @Override
    public PageResponse<CustomerResponse> listAll(PageRequestDTO pageRequest) {

        log.info("List all | Listing all customers in database");
        var pageCostumer = customerService.listAll(PageRequest.of(pageRequest.getPageNumber(), pageRequest.getPageSize(), Sort.by(pageRequest.getSort())));
        return ICustomerMapper.INSTANCE.toPageResponseCustomerResponse(pageCostumer);
    }

}
