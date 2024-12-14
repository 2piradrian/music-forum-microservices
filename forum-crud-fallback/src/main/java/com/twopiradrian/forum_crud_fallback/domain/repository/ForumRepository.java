package com.twopiradrian.forum_crud_fallback.domain.repository;


import com.twopiradrian.forum_crud_fallback.domain.entity.Forum;

public interface ForumRepository {

    Forum getById(Long forumId);

}
