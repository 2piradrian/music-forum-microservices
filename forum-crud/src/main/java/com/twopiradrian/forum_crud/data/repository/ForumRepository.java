package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.domain.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long> {

}
