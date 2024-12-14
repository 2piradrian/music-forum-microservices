package com.twopiradrian.forum_crud_fallback.domain.repository;


import com.twopiradrian.forum_crud_fallback.domain.entity.Comment;

public interface CommentRepository {

    Comment getById(Long commentId);

}
