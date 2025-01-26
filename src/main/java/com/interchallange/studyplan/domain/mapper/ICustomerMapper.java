package com.interchallange.studyplan.domain.mapper;

import com.interchallange.studyplan.api.response.PageResponse;
import com.interchallange.studyplan.api.response.customer.CustomerResponse;
import com.interchallange.studyplan.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    @Mapping(source = "pageCustomer.pageable.pageNumber", target = "pageNumber")
    @Mapping(source = "pageCustomer.pageable.pageSize", target = "pageSize")
    PageResponse<CustomerResponse> toPageResponseCustomerResponse(Page<Customer> pageCustomer);

}
