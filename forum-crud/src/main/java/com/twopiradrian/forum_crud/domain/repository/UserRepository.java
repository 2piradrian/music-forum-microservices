package com.twopiradrian.forum_crud.domain.repository;


import com.twopiradrian.forum_crud.domain.entity.User;

public interface UserRepository {

    User getById(String userId);

    User getByEmailOrUsername(String email, String username);

    void save(User user);

    void update(User user);

    void deleteById(String userId);
}
