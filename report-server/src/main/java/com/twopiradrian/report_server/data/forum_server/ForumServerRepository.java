package com.twopiradrian.report_server.data.forum_server;

import com.twopiradrian.entity.Forum;
import com.twopiradrian.report_server.config.beans.LoadBalancerConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "forum-server")
@LoadBalancerClient(name = "forum-server", configuration = LoadBalancerConfiguration.class)
public interface ForumServerRepository {

    @GetMapping("/forum-server/api/forum/get-monthly")
    Optional<List<Forum>> getMonthlyForums (
            @RequestHeader(value = "Authorization") String token,
            @RequestHeader(value = "month") Integer month,
            @RequestHeader(value = "year") Integer year
    );

}
