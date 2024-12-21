package com.twopiradrian.report_ms.data.repository;

import com.twopiradrian.report_ms.data.dto.forum.request.GetMonthlyForumsReq;
import com.twopiradrian.report_ms.data.forum_crud.ForumCrudRepository;
import com.twopiradrian.report_ms.domain.entity.Forum;
import com.twopiradrian.report_ms.domain.repository.ForumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ForumRepositoryI implements ForumRepository {

    private final ForumCrudRepository forumCrudRepository;

    @Override
    public List<Forum> getMonthlyForums(int month, int year) {

        GetMonthlyForumsReq dto = GetMonthlyForumsReq.create(month, year);

        var forums = this.forumCrudRepository.getMonthlyForums(dto);

        return forums != null ? null : null; // TODO: Implement the mapping
    }

}
