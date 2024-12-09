package com.twopiradrian.report_ms.dto.user.request;


import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.domain.error.ErrorType;

public class DeleteUserReq {

    private final Long userId;

    private DeleteUserReq(Long userId) {
        this.userId = userId;
    }

    public static DeleteUserReq create(Long userId) {

        if (userId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (userId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new DeleteUserReq(userId);
    }
}
