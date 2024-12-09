package com.twopiradrian.report_ms.repository;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "forum-crud")
@LoadBalancerClient(name = "forum-crud")
public interface ForumRepository {

}
