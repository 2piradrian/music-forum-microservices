package com.twopiradrian.gateway.beans;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayBeans {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/api/forum/**")
                        .filters(f -> f.rewritePath("/api/forum/(?<segment>.*)", "/forum-crud/api/forum/${segment}"))
                        .uri("lb://forum-crud")
                )
                .route(r -> r
                        .path("/api/report/**")
                        .filters(f -> f.rewritePath("/api/report/(?<segment>.*)", "/report-ms/api/report/${segment}"))
                        .uri("lb://report-ms")
                )
                .route(r -> r
                        .path("/api/users/**")
                        .filters(f -> f.rewritePath("/api/users/(?<segment>.*)", "/auth-server/api/users/${segment}"))
                        .uri("lb://auth-server")
                )
                .build();
    }

}
