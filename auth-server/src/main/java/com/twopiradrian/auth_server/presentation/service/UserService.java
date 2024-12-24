package com.twopiradrian.auth_server.presentation.service;

import com.twopiradrian.auth_server.domain.dto.user.request.*;
import com.twopiradrian.auth_server.domain.dto.user.response.CredentialsLoginUserRes;
import com.twopiradrian.auth_server.domain.dto.user.response.GetUserByIdRes;
import com.twopiradrian.auth_server.domain.dto.user.response.RegisterUserRes;
import com.twopiradrian.auth_server.domain.dto.user.response.TokenLoginUserRes;
import com.twopiradrian.auth_server.domain.entity.Token;

public interface UserService {

    GetUserByIdRes getById(GetUserByIdReq dto);

    RegisterUserRes register(RegisterUserReq dto);

    CredentialsLoginUserRes credentialsLogin(CredentialsLoginUserReq dto);

    TokenLoginUserRes tokenLoginUser(TokenLoginUserReq dto);

    void delete(DeleteUserReq dto);

}
