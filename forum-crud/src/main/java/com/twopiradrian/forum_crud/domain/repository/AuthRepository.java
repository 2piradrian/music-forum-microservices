package com.twopiradrian.forum_crud.domain.repository;

import com.twopiradrian.forum_crud.domain.entity.TokenClaims;

public interface AuthRepository {

    TokenClaims auth(String token);

}
