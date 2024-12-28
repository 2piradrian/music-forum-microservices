package com.twopiradrian.forum_crud.domain.repository;


import com.twopiradrian.forum_crud.domain.entity.Comment;
import com.twopiradrian.forum_crud.domain.entity.PageContent;

public interface CommentRepository {

    Comment getById(String commentId);

    PageContent getByForumId(String forumId, Integer page, Integer size);

    Comment save(Comment comment);

    Comment update(Comment comment);

}
