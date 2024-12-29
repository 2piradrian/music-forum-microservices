package com.twopiradrian.report_server.data.forum_server;

import com.twopiradrian.report_server.config.beans.LoadBalancerConfiguration;
import com.twopiradrian.report_server.data.dto.forum.request.GetMonthlyForumsReq;
import com.twopiradrian.report_server.data.dto.forum.response.GetMonthlyForumsRes;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "forum-server")
@LoadBalancerClient(name = "forum-server", configuration = LoadBalancerConfiguration.class)
public interface ForumServerRepository {

    @GetMapping("/forum-server/api/forum/get-monthly")
    Optional<GetMonthlyForumsRes> getMonthlyForums (@RequestBody GetMonthlyForumsReq dto);

}
