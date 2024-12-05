package com.twopiradrian.forum_crud.dto.user;

import com.twopiradrian.forum_crud.utils.ErrorHandler;
import com.twopiradrian.forum_crud.utils.ErrorType;

public class DeleteUserDTO {

    private final Long userId;

    private DeleteUserDTO(Long userId) {
        this.userId = userId;
    }

    public static DeleteUserDTO create(Long userId) {

        if (userId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (userId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new DeleteUserDTO(userId);
    }
}
