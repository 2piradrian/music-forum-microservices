package com.twopiradrian.auth_server.data.postgres.repository;

import com.twopiradrian.auth_server.data.postgres.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostgresUserRepository extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByEmail(String email);

}
