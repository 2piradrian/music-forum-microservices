package com.twopiradrian.auth_server.domain.dto.user.mapper.implementation;

import com.twopiradrian.auth_server.domain.dto.user.request.LoginUserReq;
import com.twopiradrian.auth_server.domain.dto.user.response.LoginUserRes;
import com.twopiradrian.auth_server.domain.entity.Token;

import java.util.Map;

public class LoginMapper {

    public LoginUserReq toRequest(Map<String, Object> payload) {
        return LoginUserReq.create(
                (String) payload.get("username"),
                (String) payload.get("password")
        );
    }

    public LoginUserRes toResponse(Token token) {
        return new LoginUserRes(
                token
        );
    }

}
