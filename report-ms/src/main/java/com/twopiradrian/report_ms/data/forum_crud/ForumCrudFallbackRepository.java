package com.twopiradrian.report_ms.data.forum_crud;

import com.twopiradrian.report_ms.data.dto.forum.request.GetMonthlyForumsReq;
import com.twopiradrian.report_ms.data.dto.forum.response.GetMonthlyForumsRes;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "forum-crud-fallback")
@LoadBalancerClient(name = "forum-crud-fallback")
public interface ForumCrudFallbackRepository {

    @GetMapping("/api/forum/get-monthly")
    Optional<GetMonthlyForumsRes> getMonthlyForums (@RequestBody GetMonthlyForumsReq dto);

}
