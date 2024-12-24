package com.twopiradrian.gateway.filters;

import com.twopiradrian.gateway.entity.Token;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class AuthFilter implements GatewayFilter {

    private final WebClient webClient;

    private static final String AUTH_URI = "lb://auth-server/api/users/login/token";
    private static final String AUTH_HEADER = "Authorization";

    public AuthFilter() {
        this.webClient = WebClient.builder().build();
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (!exchange.getRequest().getHeaders().containsKey(AUTH_HEADER)) {
            return this.onError(exchange);
        }

        final var header = exchange.getRequest().getHeaders().get(AUTH_HEADER).get(0);
        final var token = header.split(" ")[1];

        if (token.isBlank()) {
            return this.onError(exchange);
        }

        return this.webClient.get().uri(AUTH_URI)
                .header(AUTH_HEADER, token)
                .retrieve()
                .bodyToMono(Token.class)
                .map(response -> exchange)
                .flatMap(chain::filter);
        
    }

    private Mono<Void> onError(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

        return exchange.getResponse().setComplete();
    }

}
