package com.twopiradrian.auth_server.domain.dto.user.mapper.implementation;

import com.twopiradrian.auth_server.domain.dto.user.request.AuthUserReq;
import com.twopiradrian.auth_server.domain.dto.user.response.AuthUserRes;
import com.twopiradrian.auth_server.domain.entity.Token;
import com.twopiradrian.auth_server.domain.entity.User;

public class AuthMapper {

    public AuthUserReq toRequest(String accessToken) {
        return AuthUserReq.create(
                accessToken
        );
    }

    public AuthUserRes toResponse(User user) {
        return new AuthUserRes(
                user.getId(),
                user.getEmail(),
                user.getRoles()
        );
    }

}
