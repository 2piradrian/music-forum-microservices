package com.twopiradrian.forum_crud.domain.repository;

import com.twopiradrian.forum_crud.domain.entity.User;

public interface AuthRepository {

    User auth(String token);

}
