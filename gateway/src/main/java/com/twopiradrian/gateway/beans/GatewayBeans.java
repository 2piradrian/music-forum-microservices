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
                        .path("/api/users/**")
                        .filters(f -> f.rewritePath("/api/users/(?<segment>.*)", "/forum-crud/api/users/${segment}"))
                        .uri("lb://forum-crud")
                )
                .route(r -> r
                        .path("/report/**")
                        .filters(f -> f.rewritePath("/report/(?<segment>.*)", "/report-ms/report/${segment}"))
                        .uri("lb://report-ms")
                )
                .build();
    }

}
