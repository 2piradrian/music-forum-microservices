package com.twopiradrian.report_ms.data.repository;

import com.twopiradrian.report_ms.data.dto.forum.request.GetMonthlyForumsReq;
import com.twopiradrian.report_ms.data.forum_crud.ForumCrudRepository;
import com.twopiradrian.report_ms.data.forum_crud.ForumCrudFallbackRepository;
import com.twopiradrian.report_ms.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.report_ms.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.report_ms.domain.entity.Forum;
import com.twopiradrian.report_ms.domain.repository.ForumRepository;
import lombok.AllArgsConstructor;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ForumRepositoryI implements ForumRepository {

    private final ForumCrudRepository forumCrudRepository;
    private final ForumCrudFallbackRepository forumCrudFallbackRepository;

    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    @Override
    public List<Forum> getMonthlyForums(int month, int year) {

        GetMonthlyForumsReq dto = GetMonthlyForumsReq.create(month, year);

        var circuitBreaker = this.circuitBreakerFactory.create("forum-circuitbreaker");

        var forum = circuitBreaker.run(
                () -> this.forumCrudRepository.getMonthlyForums(dto),
                throwable -> this.forumCrudFallbackRepository.getMonthlyForums(dto));

        return forum != null ? null : null; // TODO: Implement the mapping
    }

}
