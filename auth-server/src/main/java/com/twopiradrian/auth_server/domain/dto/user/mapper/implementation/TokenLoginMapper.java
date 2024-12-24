package com.twopiradrian.auth_server.domain.dto.user.mapper.implementation;

import com.twopiradrian.auth_server.domain.dto.user.request.TokenLoginUserReq;
import com.twopiradrian.auth_server.domain.dto.user.response.TokenLoginUserRes;
import com.twopiradrian.auth_server.domain.entity.Token;

public class TokenLoginMapper {

    public TokenLoginUserReq toRequest(String accessToken) {
        return TokenLoginUserReq.create(
                accessToken
        );
    }

    public TokenLoginUserRes toResponse(Token token) {
        return new TokenLoginUserRes(
                token
        );
    }

}
