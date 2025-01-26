package com.interchallange.studyplan.core.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfig {

    private static final String DEFAULT_API_TITLE = "Inter Challenge - Project Documentation";
    private static final String DEFAULT_API_VERSION = "1.0.0";
    private static final String DEFAULT_API_DESCRIPTION = "A web service to solve Inter&co backend java challenge";

    @Bean
    public OpenAPI buildAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title(DEFAULT_API_TITLE)
                        .version(DEFAULT_API_VERSION)
                        .description(DEFAULT_API_DESCRIPTION)
                );
    }

}
