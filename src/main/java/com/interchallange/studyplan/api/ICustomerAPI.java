package com.interchallange.studyplan.api;

import com.interchallange.studyplan.api.annotation.route_description.ListAllRouteDescription;
import com.interchallange.studyplan.api.response.PageResponse;
import com.interchallange.studyplan.api.response.customer.CustomerResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Customer environment")
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public interface ICustomerAPI {

    @GetMapping("/list-all")
    @PageableAsQueryParam
    @ListAllRouteDescription
    PageResponse<CustomerResponse> listAll(@Parameter(hidden = true) Pageable pageRequest);

}
