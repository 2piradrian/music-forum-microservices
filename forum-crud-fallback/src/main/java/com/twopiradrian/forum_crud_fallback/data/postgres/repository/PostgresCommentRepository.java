package com.twopiradrian.forum_crud_fallback.data.postgres.repository;

import com.twopiradrian.forum_crud_fallback.data.postgres.model.CommentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresCommentRepository extends JpaRepository<CommentModel, Long> {

}
