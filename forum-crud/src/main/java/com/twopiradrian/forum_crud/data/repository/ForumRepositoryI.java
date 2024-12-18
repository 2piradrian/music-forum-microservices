package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.data.postgres.mapper.ForumEntityMapper;
import com.twopiradrian.forum_crud.data.postgres.model.ForumModel;
import com.twopiradrian.forum_crud.data.postgres.repository.PostgresForumRepository;
import com.twopiradrian.forum_crud.domain.entity.Forum;
import com.twopiradrian.forum_crud.domain.repository.ForumRepository;
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

    @Override
    public void save(Forum forum) {
        ForumModel forumModel = ForumEntityMapper.toModel(forum);
        forumRepository.save(forumModel);
    }

    @Override
    public void update(Forum forum) {
        ForumModel forumModel = ForumEntityMapper.toModel(forum);
        forumRepository.save(forumModel);
    }

    @Override
    public void deleteById(Long forumId) {
        forumRepository.deleteById(forumId);
    }

}
