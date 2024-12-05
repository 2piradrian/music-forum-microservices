package com.twopiradrian.forum_crud.repository;

import com.twopiradrian.forum_crud.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
