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
                        .uri("lb://forum-crud")
                )
                .route(r -> r
                        .path("/api/report/**")
                        .uri("lb://report-ms")
                )
                .build();
    }

}
