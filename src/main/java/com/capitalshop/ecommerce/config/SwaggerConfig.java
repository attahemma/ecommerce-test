package com.capitalshop.ecommerce.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("Ecommerce API")
                .pathsToMatch("/**")
                .addOperationCustomizer((operation, handlerMethod) -> {
                    // Add the security requirement to each operation
                    operation.addSecurityItem(new SecurityRequirement().addList("Bearer"));
                    return operation;
                })
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("CapitalShop Ecommerce API")
                        .description("Production Environment")
                        .version("1.0"))
                .addSecurityItem(new SecurityRequirement().addList("Bearer"))
                .components(new Components()
                        .addSecuritySchemes("Bearer",
                                new SecurityScheme().type(SecurityScheme.Type.APIKEY)
                                        .in(SecurityScheme.In.HEADER)
                                        .name("Authorization")
                                        .scheme("Bearer")));
    }
}
