package com.twopiradrian.forum_crud_fallback.data.postgres.repository;

import com.twopiradrian.forum_crud_fallback.data.postgres.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresUserRepository extends JpaRepository<UserModel, Long> {

}
