package com.microservices.apigateway.routes;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.client.HttpClient;

@Configuration
public class RoutesConfig {
    @Bean
    public RouteLocator  routes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p-> p.path("/doctor/**")
                        .uri("lb://DOCTOR-SERVICE/**"))
                .route(p-> p.path("/patient/**")
                        .uri("lb://PATIENT-SERVICE/**"))
                .route(p-> p.path("/payment/**")
                        .uri("lb://PAYMENT-SERVICE/**"))
                .build();
    }

}
