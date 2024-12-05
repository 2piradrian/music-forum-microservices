package com.twopiradrian.forum_crud.repositories;

import com.twopiradrian.forum_crud.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
