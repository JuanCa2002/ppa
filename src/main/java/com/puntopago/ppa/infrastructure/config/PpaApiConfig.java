package com.puntopago.ppa.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PpaApiConfig {

    @Value("${spring.config.activate.on-profile}")
    private String profile;

    private static final String SERVER_PORT = "2208";

    @Bean
    public OpenAPI springAccommodationOpenAPI() {
        String prefix = profile.equals("dev") ? "http://localhost:" + SERVER_PORT : "https://ppa-production.up.railway.app";

        return new OpenAPI()
                .info(new Info().title("PPA management API")
                        .description("API that provides services for the management, administration and control of Punto Pago Air (PPA)")
                        .version("v0.0.1"))
                .servers(
                        List.of(
                                new Server().url(prefix + "/api/v1/ppa").description("API Gateway")
                        )
                );
    }
}
