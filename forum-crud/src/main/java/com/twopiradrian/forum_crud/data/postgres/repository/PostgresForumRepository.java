package com.twopiradrian.forum_crud.data.postgres.repository;

import com.twopiradrian.forum_crud.data.postgres.model.ForumModel;
import com.twopiradrian.forum_crud.domain.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresForumRepository extends JpaRepository<ForumModel, Long> {

}
