package com.twopiradrian.forum_crud.services;

import com.twopiradrian.forum_crud.entities.Comment;

public interface CommentService {

    Comment getById(Long id);

    Comment create(Comment comment);

    Comment update(Comment comment);

    void delete(Long id);

}
