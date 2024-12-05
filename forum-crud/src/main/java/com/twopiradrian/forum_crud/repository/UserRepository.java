package com.twopiradrian.forum_crud.repository;

import com.twopiradrian.forum_crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
