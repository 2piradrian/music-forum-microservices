package com.twopiradrian.report_server.data.repository;

import com.twopiradrian.entity.Forum;
import com.twopiradrian.report_server.data.dto.forum.request.GetMonthlyForumsReq;
import com.twopiradrian.report_server.data.forum_server.ForumServerRepository;
import com.twopiradrian.report_server.domain.repository.ForumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ForumRepositoryI implements ForumRepository {

    private final ForumServerRepository forumServerRepository;

    @Override
    public List<Forum> getMonthlyForums(Integer month, Integer year) {

        GetMonthlyForumsReq dto = GetMonthlyForumsReq.create(month, year);

        var forums = this.forumServerRepository.getMonthlyForums(dto);

        return forums != null ? null : null; // TODO: Implement the mapping
    }

}
