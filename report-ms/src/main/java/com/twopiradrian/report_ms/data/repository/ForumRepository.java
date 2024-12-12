package com.twopiradrian.report_ms.data.repository;

import com.twopiradrian.report_ms.domain.dto.forum.response.CreateForumRes;
import com.twopiradrian.report_ms.domain.dto.forum.response.GetForumByIdRes;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

@FeignClient(name = "forum-crud")
@LoadBalancerClient(name = "forum-crud")
public interface ForumRepository {

    @GetMapping("/api/forum/get-by-id/{forumId}")
    Optional<GetForumByIdRes> getForumById (@PathVariable("forumId") Long forumId);

}
