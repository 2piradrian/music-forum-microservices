package com.twopiradrian.auth_server.domain.dto.user.request;

import com.twopiradrian.auth_server.domain.error.ErrorHandler;
import com.twopiradrian.auth_server.domain.error.ErrorType;
import lombok.Getter;

@Getter
public class AuthUserReq {

    private final String accessToken;

    private AuthUserReq(String accessToken) {
        this.accessToken = accessToken;
    }

    public static AuthUserReq create(String accessToken) {

        if (accessToken == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        return new AuthUserReq(accessToken);
    }
}
