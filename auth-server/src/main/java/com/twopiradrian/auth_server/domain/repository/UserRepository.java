package com.twopiradrian.auth_server.domain.repository;


import com.twopiradrian.auth_server.domain.entity.User;

public interface UserRepository {

    User getById(String userId);

    User getByEmail(String email);

    User getByUsername(String username);

    User save(User user);

    User update(User user);

    void deleteById(String userId);
}
