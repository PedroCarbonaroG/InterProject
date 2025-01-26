package com.interchallange.studyplan.api.annotation.route_description;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(
        summary = "Responsible route to list all customers in database",
        description = "If everything went right, returns a paginated list of all customers in database",
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "If everything went right, returns OK.")})
public @interface ListAllRouteDescription {
}
