package com.twopiradrian.forum_crud.data.postgres;

import com.twopiradrian.forum_crud.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresCommentRepository extends JpaRepository<Comment, Long> {

}
