package com.interchallange.studyplan.api.response.customer;

import lombok.Builder;

@Builder
public record CustomerResponse(String name, String email, String phoneNumber) {
}
