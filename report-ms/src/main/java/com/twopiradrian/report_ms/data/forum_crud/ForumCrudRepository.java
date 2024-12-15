package com.twopiradrian.report_ms.data.forum_crud;

import com.twopiradrian.report_ms.data.dto.forum.request.GetMonthlyForumsReq;
import com.twopiradrian.report_ms.data.dto.forum.response.GetMonthlyForumsRes;
import com.twopiradrian.report_ms.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.report_ms.domain.dto.forum.response.MakeMonthlyForumReportRes;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "forum-crud")
@LoadBalancerClient(name = "forum-crud")
public interface ForumCrudRepository {

    @GetMapping("/api/forum/get-monthly")
    Optional<GetMonthlyForumsRes> getMonthlyForums (@RequestBody GetMonthlyForumsReq dto);

}
