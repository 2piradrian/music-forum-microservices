package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.data.auth_server.AuthServerRepository;
import com.twopiradrian.forum_crud.domain.entity.User;
import com.twopiradrian.forum_crud.domain.repository.AuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AuthRepositoryI implements AuthRepository {

    private final AuthServerRepository authServerRepository;

    @Override
    public User auth(String token) {
        Optional<User> user = this.authServerRepository.auth(token);

        return user.orElse(null);
    }

}
