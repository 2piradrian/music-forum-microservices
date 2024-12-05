package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.dto.forum.CreateForumDTO;
import com.twopiradrian.forum_crud.entity.Forum;

public interface ForumService {

    Forum getById(Long id);

    Forum create(CreateForumDTO dto);

    Forum edit(Forum forum);

    void updateUpvoters(Long forumId, Long userId);

    void delete(Long id);
}
