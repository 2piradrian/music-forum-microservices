package com.twopiradrian.forum_crud.infrastructure.repository;

import com.twopiradrian.forum_crud.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
