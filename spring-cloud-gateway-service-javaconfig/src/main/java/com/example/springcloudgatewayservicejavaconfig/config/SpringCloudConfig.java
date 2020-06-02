package com.example.springcloudgatewayservicejavaconfig.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
  Use java based Configuration to programmatically create routes.
* */
@Configuration
public class SpringCloudConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/employee/**")
                        .uri("http://localhost:8082/")
                        .id("employeeModule"))

                .route(r -> r.path("/consumer/**")
                        .uri("http://localhost:8083/")
                        .id("consumerModule"))
                .build();
    }
}