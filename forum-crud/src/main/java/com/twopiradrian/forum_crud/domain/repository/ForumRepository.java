package com.twopiradrian.forum_crud.domain.repository;

import com.twopiradrian.forum_crud.domain.entity.Forum;
import com.twopiradrian.forum_crud.domain.entity.PageContent;

public interface ForumRepository {

    Forum getById(String forumId);

    PageContent<Forum> getAllForums(Integer page, Integer size, String category);

    Forum save(Forum forum);

    Forum update(Forum forum);

}
