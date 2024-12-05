package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.entity.Comment;

public interface CommentService {

    Comment getById(Long id);

    Comment create(Comment comment);

    Comment update(Comment comment);

    void delete(Long id);

}
