package com.twopiradrian.forum_crud_fallback.data.postgres.repository;


import com.twopiradrian.forum_crud_fallback.data.postgres.model.ForumModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresForumRepository extends JpaRepository<ForumModel, Long> {

}
