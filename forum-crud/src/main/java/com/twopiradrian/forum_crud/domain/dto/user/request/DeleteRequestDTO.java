package com.twopiradrian.forum_crud.domain.dto.user.request;


import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.domain.error.ErrorType;

public class DeleteRequestDTO {

    private final Long userId;

    private DeleteRequestDTO(Long userId) {
        this.userId = userId;
    }

    public static DeleteRequestDTO create(Long userId) {

        if (userId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (userId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new DeleteRequestDTO(userId);
    }
}