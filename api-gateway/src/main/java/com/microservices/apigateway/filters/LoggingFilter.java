package com.microservices.apigateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@Component
public class LoggingFilter implements GlobalFilter {
    Logger logger = Logger.getLogger(LoggingFilter.class.getName());
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Request coming.....");
        ServerHttpRequest request = exchange.getRequest();
        String url = request.getURI().toString();

        String countryName = request.getHeaders().getFirst("country");

        if (countryName.equals("US")){
            try {
                throw new Exception("Country not allowed");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        logger.info("URL : " + url);
        return chain.filter(exchange);
    }
}
