package com.interchallange.studyplan.api.annotation.route_description;

import com.interchallange.studyplan.api.exception_handler.response.ErrorResponse;
import com.interchallange.studyplan.api.response.customer.CustomerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(
        summary = "Responsible route to create a new customer.",
        description = "If everything went right, creates a new customer and returns the created entity.",
        responses = {
                @ApiResponse(
                        responseCode = "201",
                        description = "If everything went right, returns created.",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = CustomerResponse.class))),
                @ApiResponse(
                        responseCode = "404 • 500",
                        description = "If something goes wrong with data or application resources, returns treated error.",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))})
public @interface CreateCustomerRouteDescription {}
