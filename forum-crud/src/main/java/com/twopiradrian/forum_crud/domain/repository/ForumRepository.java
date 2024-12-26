package com.twopiradrian.forum_crud.domain.repository;

import com.twopiradrian.forum_crud.domain.entity.Forum;

public interface ForumRepository {

    Forum getById(Long forumId);

    Forum save(Forum forum);

    Forum update(Forum forum);

    void deleteById(Long forumId);

}
