package com.interchallange.studyplan.api.annotation.route_param;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Parameter(
        in = ParameterIn.QUERY,
        name = "name",
        description = "Customer full name (Alan Turing)",
        schema = @Schema(implementation = String.class),
        required = true)
@Parameter(
        in = ParameterIn.QUERY,
        name = "email",
        description = "Customer full email (alanTuring@email.com)",
        schema = @Schema(implementation = String.class),
        required = true)
@Parameter(
        in = ParameterIn.QUERY,
        name = "phoneNumber",
        description = "Customer full phone number (12912345678) 11 digits",
        schema = @Schema(implementation = String.class))
public @interface CustomerRequestRequiredAsQueryParam {
}
