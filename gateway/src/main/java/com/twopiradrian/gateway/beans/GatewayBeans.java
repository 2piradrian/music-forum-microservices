package com.twopiradrian.gateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class GatewayBeans {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/forum-crud/**")
                        .filters(f -> f.circuitBreaker(c -> c
                                .setName("gateway-cb")
                                .setFallbackUri("forward:/forum-crud-fallback/**")
                        ))
                        .uri("lb://forum-crud")
                )
                .route(r -> r
                        .path("/forum-crud-fallback/**")
                        .uri("lb://forum-crud-fallback")
                )
                .build();
    }

}
