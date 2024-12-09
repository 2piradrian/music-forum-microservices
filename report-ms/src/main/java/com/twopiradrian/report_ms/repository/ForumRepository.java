package com.twopiradrian.report_ms.repository;

import com.twopiradrian.report_ms.dto.forum.request.GetForumByIdReq;
import com.twopiradrian.report_ms.dto.forum.response.GetForumByIdRes;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

@FeignClient(name = "forum-crud")
@LoadBalancerClient(name = "forum-crud")
public interface ForumRepository {

    @GetMapping("/api/forum/get-by-id")
    Optional<GetForumByIdRes> getForumById (@RequestBody Map<String, Object> payload);

    
}
