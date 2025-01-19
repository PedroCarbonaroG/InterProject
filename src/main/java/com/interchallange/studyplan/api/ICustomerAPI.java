package com.interchallange.studyplan.api;

import com.interchallange.studyplan.api.request.PageRequestDTO;
import com.interchallange.studyplan.api.response.PageResponse;
import com.interchallange.studyplan.api.response.customer.CustomerResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public interface ICustomerAPI {

    @GetMapping
    PageResponse<CustomerResponse> listAll(@RequestBody PageRequestDTO pageRequest);

}
