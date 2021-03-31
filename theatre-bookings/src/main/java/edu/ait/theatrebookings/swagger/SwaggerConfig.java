package edu.ait.theatrebookings.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {

    public static final Contact CUSTOM_CONTACT = new Contact("Russell Hill",
            "https://theatre-booking-systems.com/about/",
            "john@springfrmework.guru");

    public static final ApiInfo CUSTOM_API_INFO = new ApiInfo(
            "Spring Boot REST API",
            "Spring Boot REST API for Theatre Bookings",
            "1.0",
            "Terms of service",
            CUSTOM_CONTACT,
            "Apache License Version 2.0",
            "https://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList<VendorExtension>());

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(CUSTOM_API_INFO);
    }
}
