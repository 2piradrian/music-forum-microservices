package com.twopiradrian.forum_crud_fallback.domain.repository;

import com.twopiradrian.forum_crud_fallback.domain.entity.User;

public interface UserRepository {

    User getById(Long userId);

}
