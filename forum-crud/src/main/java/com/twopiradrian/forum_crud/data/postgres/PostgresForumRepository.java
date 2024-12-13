package com.twopiradrian.forum_crud.data.postgres;

import com.twopiradrian.forum_crud.domain.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresForumRepository extends JpaRepository<Forum, Long> {

}
