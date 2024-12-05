package com.twopiradrian.forum_crud.services;

import com.twopiradrian.forum_crud.entities.Forum;

public interface ForumService {

    Forum getById(Long id);

    Forum create(Forum forum);

    Forum edit(Forum forum);

    void updateUpvoters(Long forumId, Long userId);

    void delete(Long id);
}
