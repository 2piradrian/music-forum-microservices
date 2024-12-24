package com.twopiradrian.auth_server.domain.dto.user.mapper.implementation;

import com.twopiradrian.auth_server.domain.dto.user.request.CredentialsLoginUserReq;
import com.twopiradrian.auth_server.domain.dto.user.response.CredentialsLoginUserRes;
import com.twopiradrian.auth_server.domain.entity.Token;

import java.util.Map;

public class CredentialsLoginMapper {

    public CredentialsLoginUserReq toRequest(Map<String, Object> payload) {
        return CredentialsLoginUserReq.create(
                (String) payload.get("username"),
                (String) payload.get("password")
        );
    }

    public CredentialsLoginUserRes toResponse(Token token) {
        return new CredentialsLoginUserRes(
                token
        );
    }

}
