package com.twopiradrian.forum_crud.domain.repository;


import com.twopiradrian.forum_crud.domain.entity.Comment;

public interface CommentRepository {

    Comment getById(String commentId);

    Comment save(Comment comment);

    Comment update(Comment comment);

    void deleteById(String commentId);

}
