package com.twopiradrian.forum_crud.repositories;

import com.twopiradrian.forum_crud.entities.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long> {

}
