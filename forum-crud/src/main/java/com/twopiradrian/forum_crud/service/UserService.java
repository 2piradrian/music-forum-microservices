package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.dto.forum.DeleteForumDTO;
import com.twopiradrian.forum_crud.dto.forum.GetForumByIdDTO;
import com.twopiradrian.forum_crud.dto.user.LoginUserDTO;
import com.twopiradrian.forum_crud.dto.user.RegisterUserDTO;
import com.twopiradrian.forum_crud.entity.User;

public interface UserService {

    User getById(GetForumByIdDTO dto);

    User register(RegisterUserDTO dto);

    User login(LoginUserDTO dto);

    void delete(DeleteForumDTO dto);

}
