package com.twopiradrian.forum_crud.data.postgres.repository;

import com.twopiradrian.forum_crud.data.postgres.model.CommentModel;
import com.twopiradrian.forum_crud.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresCommentRepository extends JpaRepository<CommentModel, Long> {

}
