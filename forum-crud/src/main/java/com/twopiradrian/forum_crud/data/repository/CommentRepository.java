package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
