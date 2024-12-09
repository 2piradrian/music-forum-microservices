package com.twopiradrian.forum_crud.presentation.service;


import com.twopiradrian.forum_crud.domain.dto.user.response.GetUserByIdRes;
import com.twopiradrian.forum_crud.domain.dto.user.request.DeleteUserReq;
import com.twopiradrian.forum_crud.domain.dto.user.request.GetUserByIdReq;
import com.twopiradrian.forum_crud.domain.dto.user.request.LoginUserReq;
import com.twopiradrian.forum_crud.domain.dto.user.request.RegisterUserReq;
import com.twopiradrian.forum_crud.domain.dto.user.response.RegisterUserRes;
import com.twopiradrian.forum_crud.domain.entity.User;

public interface UserService {

    GetUserByIdRes getById(GetUserByIdReq dto);

    RegisterUserRes register(RegisterUserReq dto);

    User login(LoginUserReq dto);

    void delete(DeleteUserReq dto);

}
