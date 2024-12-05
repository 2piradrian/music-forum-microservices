package com.twopiradrian.forum_crud.repositories;

import com.twopiradrian.forum_crud.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
