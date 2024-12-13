package com.twopiradrian.forum_crud.data.postgres;

import com.twopiradrian.forum_crud.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresUserRepository extends JpaRepository<User, Long> {

}
