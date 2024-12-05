package com.twopiradrian.forum_crud.repository;

import com.twopiradrian.forum_crud.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long> {

}
