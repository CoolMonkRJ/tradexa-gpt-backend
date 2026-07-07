package com.tradexa.gpt.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI tradexaOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("Tradexa GPT API")
                        .version("1.0")
                        .description("Backend APIs for Tradexa GPT - Trade Analytics Platform")
                        .contact(new Contact()
                                .name("Rohit Joshi")
                                .email("workwithrj07@gmail.com")));
    }
}