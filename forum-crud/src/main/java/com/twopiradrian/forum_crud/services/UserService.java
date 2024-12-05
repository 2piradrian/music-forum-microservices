package com.twopiradrian.forum_crud.services;

import com.twopiradrian.forum_crud.entities.User;

public interface UserService {

    User getById(Long id);

    User create(User user);

    User update(User user);

    void delete(Long id);

}
