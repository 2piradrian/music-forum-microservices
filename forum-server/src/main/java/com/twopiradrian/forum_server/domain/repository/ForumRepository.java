package com.twopiradrian.forum_server.domain.repository;

import com.twopiradrian.entity.Forum;
import com.twopiradrian.entity.PageContent;

import java.util.List;

public interface ForumRepository {

    Forum getById(String forumId);

    PageContent<Forum> getAllForums(Integer page, Integer size, String category);

    List<Forum> getMonthlyForums(int month, int year);

    Forum save(Forum forum);

    Forum update(Forum forum);

}
