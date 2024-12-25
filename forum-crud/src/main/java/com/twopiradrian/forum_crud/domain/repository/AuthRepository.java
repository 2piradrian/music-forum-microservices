package com.twopiradrian.forum_crud.domain.repository;

import com.twopiradrian.forum_crud.domain.entity.TokenClaims;
import com.twopiradrian.forum_crud.domain.entity.User;

public interface AuthRepository {

    TokenClaims auth(String token);

    User getById(Long userId);

}
