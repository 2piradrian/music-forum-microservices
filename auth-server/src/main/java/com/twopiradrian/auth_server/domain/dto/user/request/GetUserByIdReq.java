package com.twopiradrian.auth_server.domain.dto.user.request;

import com.twopiradrian.auth_server.domain.error.ErrorHandler;
import com.twopiradrian.auth_server.domain.error.ErrorType;
import lombok.Getter;

@Getter
public class GetUserByIdReq {

    private final Long userId;

    private GetUserByIdReq(Long userId) {
        this.userId = userId;
    }

    public static GetUserByIdReq create(Long userId) {

        if (userId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (userId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new GetUserByIdReq(userId);
    }

}
