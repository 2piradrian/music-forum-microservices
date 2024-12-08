package com.twopiradrian.forum_crud.domain.dto.user.request;

import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.domain.error.ErrorType;
import lombok.Getter;

@Getter
public class GetByIdRequestDTO {

    private final Long userId;

    private GetByIdRequestDTO(Long userId) {
        this.userId = userId;
    }

    public static GetByIdRequestDTO create(Long userId) {

        if (userId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (userId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new GetByIdRequestDTO(userId);
    }

}
