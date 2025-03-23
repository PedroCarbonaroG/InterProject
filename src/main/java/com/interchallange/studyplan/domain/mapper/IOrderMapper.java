package com.interchallange.studyplan.domain.mapper;

import com.interchallange.studyplan.api.response.customer.CustomerResponse;
import com.interchallange.studyplan.api.response.order.CustomerOrderResponse;
import com.interchallange.studyplan.api.response.order.OrderResponse;
import com.interchallange.studyplan.domain.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IOrderMapper {

    IOrderMapper INSTANCE = Mappers.getMapper(IOrderMapper.class);

    OrderResponse toOrderResponse(Order order);

    List<OrderResponse> toOrderResponseList(List<Order> orders);

    default CustomerOrderResponse toCustomerOrderResponse(CustomerResponse customer, List<OrderResponse> orders) {

        return CustomerOrderResponse
                .builder()
                .name(customer.name())
                .email(customer.email())
                .phoneNumber(customer.phoneNumber())
                .orders(orders)
                .build();
    }

}
