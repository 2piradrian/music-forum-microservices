package com.twopiradrian.report_server.data.repository;

import com.twopiradrian.entity.Forum;
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
    public List<Forum> getMonthlyForums(String token, Integer month, Integer year) {

        var forums = this.forumServerRepository.getMonthlyForums(token, month, year);

        return forums.orElse(null);
    }

}
