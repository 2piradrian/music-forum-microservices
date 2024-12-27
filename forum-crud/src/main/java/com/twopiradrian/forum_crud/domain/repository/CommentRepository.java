package com.twopiradrian.forum_crud.domain.repository;


import com.twopiradrian.forum_crud.domain.entity.Comment;

public interface CommentRepository {

    Comment getById(String commentId);

    void save(Comment comment);

    void update(Comment comment);

    void deleteById(String commentId);

}
