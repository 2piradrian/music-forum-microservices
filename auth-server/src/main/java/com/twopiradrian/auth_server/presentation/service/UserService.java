package com.twopiradrian.auth_server.presentation.service;

import com.twopiradrian.auth_server.domain.dto.user.request.DeleteUserReq;
import com.twopiradrian.auth_server.domain.dto.user.request.GetUserByIdReq;
import com.twopiradrian.auth_server.domain.dto.user.request.LoginUserReq;
import com.twopiradrian.auth_server.domain.dto.user.request.RegisterUserReq;
import com.twopiradrian.auth_server.domain.dto.user.response.GetUserByIdRes;
import com.twopiradrian.auth_server.domain.dto.user.response.RegisterUserRes;
import com.twopiradrian.auth_server.domain.entity.Token;
import com.twopiradrian.auth_server.domain.entity.User;

public interface UserService {

    GetUserByIdRes getById(GetUserByIdReq dto);

    RegisterUserRes register(RegisterUserReq dto);

    Token login(LoginUserReq dto);

    void delete(DeleteUserReq dto);

}
