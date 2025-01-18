package com.interchallange.studyplan.domain.enums;

import jdk.jfr.Description;

public enum OrderStatus {

    @Description("Customer is able to include/remove items from order")
    PENDANT,
    @Description("Order is closed and waiting for payment")
    PROCESSING,
    @Description("Order was paid with success")
    FINISHED,
    @Description("Order was cancelled before the payment was done")
    CANCELED;

}
