package com.interchallange.studyplan.api.request;

import lombok.Builder;

@Builder
public record PageRequestDTO(int pageNumber, int pageSize, String sort) {
}
