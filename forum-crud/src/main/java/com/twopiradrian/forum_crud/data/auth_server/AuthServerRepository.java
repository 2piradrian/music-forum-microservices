package com.twopiradrian.forum_crud.data.auth_server;

import com.twopiradrian.forum_crud.domain.entity.TokenClaims;
import com.twopiradrian.forum_crud.domain.entity.User;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Optional;

@FeignClient(name = "auth-server")
@LoadBalancerClient(name = "auth-server")
public interface AuthServerRepository {

    @GetMapping("/api/users/auth")
    Optional<TokenClaims> auth (@RequestHeader("Authorization") String token);

    @GetMapping("/api/users/get-by-id/{userId}")
    Optional<User> getById (@PathVariable Long userId);

}
