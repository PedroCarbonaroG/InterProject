package com.interchallange.studyplan.api.request.customer;

import lombok.Builder;

@Builder
public record CustomerRequest(String name, String email, String phoneNumber) {
}
