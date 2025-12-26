package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // Define JWT security scheme
        SecurityScheme bearerAuth = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        return new OpenAPI()
                // ✅ Your server URL (kept as-is)
                .servers(List.of(
                        new Server().url("https://9288.408procr.amypo.ai/")
                ))

                // ✅ Add security scheme
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", bearerAuth)
                )

                // ✅ Apply security globally
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}
