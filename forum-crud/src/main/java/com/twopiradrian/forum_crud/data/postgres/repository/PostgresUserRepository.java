package com.twopiradrian.forum_crud.data.postgres.repository;

import com.twopiradrian.forum_crud.data.postgres.model.UserModel;
import com.twopiradrian.forum_crud.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresUserRepository extends JpaRepository<UserModel, Long> {

}
