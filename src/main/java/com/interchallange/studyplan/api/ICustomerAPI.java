package com.interchallange.studyplan.api;

import com.interchallange.studyplan.api.annotation.route_description.*;
import com.interchallange.studyplan.api.annotation.route_param.CustomerRequestAsQueryParam;
import com.interchallange.studyplan.api.annotation.route_param.CustomerRequestRequiredAsQueryParam;
import com.interchallange.studyplan.api.request.customer.CustomerRequest;
import com.interchallange.studyplan.api.response.PageResponse;
import com.interchallange.studyplan.api.response.customer.CustomerResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Customer environment API")
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public interface ICustomerAPI {

    @GetMapping("/list-all")
    @PageableAsQueryParam
    @ListAllCustomerRouteDescription
    PageResponse<CustomerResponse> listAll(
            @Parameter(required = false) String name,
            @Parameter(hidden = true) Pageable pageRequest);

    @GetMapping("/id")
    @FindCustomerByIdRouteDescription
    CustomerResponse findById(@RequestParam String id);

    @PostMapping
    @CreateCustomerRouteDescription
    @CustomerRequestRequiredAsQueryParam
    CustomerResponse create(@Parameter(hidden = true, required = true) CustomerRequest customerRequest);

    @PatchMapping
    @CustomerRequestAsQueryParam
    @UpdateCustomerRouteDescription
    CustomerResponse update(
            @RequestHeader String id,
            @Parameter(hidden = true) CustomerRequest customerRequest);

    @DeleteMapping
    @DeleteCustomerRouteDescription
    void delete(@RequestHeader String id);

}
