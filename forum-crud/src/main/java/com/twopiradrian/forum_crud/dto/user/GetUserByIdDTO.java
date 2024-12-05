package com.twopiradrian.forum_crud.dto.user;

import com.twopiradrian.forum_crud.utils.ErrorHandler;
import com.twopiradrian.forum_crud.utils.ErrorType;
import lombok.Getter;

@Getter
public class GetUserByIdDTO {

    private final Long userId;

    private GetUserByIdDTO(Long userId) {
        this.userId = userId;
    }

    public static GetUserByIdDTO create(Long userId) {

        if (userId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (userId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new GetUserByIdDTO(userId);
    }

}
