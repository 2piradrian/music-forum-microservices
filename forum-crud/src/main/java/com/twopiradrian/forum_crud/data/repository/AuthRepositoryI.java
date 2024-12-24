package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.data.auth_server.AuthServerRepository;
import com.twopiradrian.forum_crud.domain.entity.TokenClaims;
import com.twopiradrian.forum_crud.domain.repository.AuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class AuthRepositoryI implements AuthRepository {

    private final AuthServerRepository authServerRepository;

    @Override
    public TokenClaims auth(String token) {
        Optional<TokenClaims> claims = this.authServerRepository.auth(token);

        return claims.orElse(null);
    }

}
