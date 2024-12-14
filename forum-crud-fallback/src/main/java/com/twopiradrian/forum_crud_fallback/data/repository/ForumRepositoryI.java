package com.twopiradrian.forum_crud_fallback.data.repository;

import com.twopiradrian.forum_crud_fallback.data.postgres.mapper.ForumEntityMapper;
import com.twopiradrian.forum_crud_fallback.data.postgres.model.ForumModel;
import com.twopiradrian.forum_crud_fallback.data.postgres.repository.PostgresForumRepository;
import com.twopiradrian.forum_crud_fallback.domain.entity.Forum;
import com.twopiradrian.forum_crud_fallback.domain.repository.ForumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ForumRepositoryI implements ForumRepository {

    private final PostgresForumRepository forumRepository;

    @Override
    public Forum getById(Long forumId) {
        ForumModel forumModel = forumRepository.findById(forumId).orElse(null);
        return forumModel != null ? ForumEntityMapper.toDomain(forumModel) : null;
    }

}
