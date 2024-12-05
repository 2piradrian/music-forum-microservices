package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.entity.User;

public interface UserService {

    User getById(Long id);

    User create(User user);

    User update(User user);

    void delete(Long id);

}
