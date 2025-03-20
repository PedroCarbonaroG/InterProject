package com.interchallange.studyplan.api.annotation.route_description;

import com.interchallange.studyplan.api.exception_handler.response.ErrorResponse;
import com.interchallange.studyplan.api.response.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(
        summary = "Responsible route to return all customers.",
        description = "If everything went right, returns all customers as a paginated JSON list.",
        responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "If everything went right, returns OK.",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = PageResponse.class))),
                @ApiResponse(
                        responseCode = "204",
                        description = "If everything went right but no data was found, returns no content.",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
                @ApiResponse(
                        responseCode = "404 • 500",
                        description = "If something goes wrong with data or application resources, returns treated error.",
                        content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))})
public @interface ListAllCustomerRouteDescription {}
