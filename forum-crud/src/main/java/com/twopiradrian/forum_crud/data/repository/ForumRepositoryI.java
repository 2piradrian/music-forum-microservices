package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.data.postgres.mapper.ForumEntityMapper;
import com.twopiradrian.forum_crud.data.postgres.model.ForumModel;
import com.twopiradrian.forum_crud.data.postgres.repository.PostgresForumRepository;
import com.twopiradrian.forum_crud.domain.entity.Forum;
import com.twopiradrian.forum_crud.domain.entity.Status;
import com.twopiradrian.forum_crud.domain.repository.ForumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ForumRepositoryI implements ForumRepository {

    private final PostgresForumRepository forumRepository;

    @Override
    public Forum getById(String forumId) {
        ForumModel forumModel = forumRepository.findById(forumId).orElse(null);

        if (forumModel == null) {
            return null;
        }

        if (forumModel.getStatus().equals(Status.DELETED)) {
            return null;
        }

        return ForumEntityMapper.toDomain(forumModel);
    }

    @Override
    public Forum save(Forum forum) {
        ForumModel forumModel = ForumEntityMapper.toModel(forum);
        ForumModel saved = forumRepository.save(forumModel);

        return ForumEntityMapper.toDomain(saved);
    }

    @Override
    public Forum update(Forum forum) {
        ForumModel forumModel = ForumEntityMapper.toModel(forum);
        ForumModel updated = forumRepository.save(forumModel);

        return ForumEntityMapper.toDomain(updated);
    }

}
