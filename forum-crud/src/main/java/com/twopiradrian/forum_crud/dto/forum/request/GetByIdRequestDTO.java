package com.twopiradrian.forum_crud.dto.forum.request;

import com.twopiradrian.forum_crud.utils.ErrorHandler;
import com.twopiradrian.forum_crud.utils.ErrorType;
import lombok.Getter;

@Getter
public class GetByIdRequestDTO {

    private final Long forumId;

    private GetByIdRequestDTO(Long forumId) {
        this.forumId = forumId;
    }

    public static GetByIdRequestDTO create(Long forumId) {

        if (forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (forumId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new GetByIdRequestDTO(forumId);
    }

}
