package com.twopiradrian.forum_crud.data.postgres.repository;

import com.twopiradrian.forum_crud.data.postgres.model.CommentModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresCommentRepository extends JpaRepository<CommentModel, String> {

    Page<CommentModel> findAllByForumId(String forumId, Pageable pageable);

}
