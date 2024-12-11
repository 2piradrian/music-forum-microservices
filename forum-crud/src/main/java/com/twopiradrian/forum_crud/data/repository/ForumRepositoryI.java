package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.data.postgres.PostgresForumRepository;
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
        return forumRepository.findById(forumId).orElse(null);
    }

    @Override
    public void save(Forum forum) {
        forumRepository.save(forum);
    }

    @Override
    public void update(Forum forum) {
        forumRepository.save(forum);
    }

    @Override
    public void deleteById(Long forumId) {
        forumRepository.deleteById(forumId);
    }

}
