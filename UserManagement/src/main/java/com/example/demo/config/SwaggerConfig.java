package com.example.demo.config;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
@Configuration
public class SwaggerConfig {

    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("UMS")
                        .description("User Management System")
                        .version("v0.0.1"));
    }
}
