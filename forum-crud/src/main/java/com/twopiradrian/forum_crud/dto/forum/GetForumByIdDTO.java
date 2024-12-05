package com.twopiradrian.forum_crud.dto.forum;

import com.twopiradrian.forum_crud.utils.ErrorHandler;
import com.twopiradrian.forum_crud.utils.ErrorType;
import lombok.Getter;

@Getter
public class GetForumByIdDTO {

    private final Long forumId;

    private GetForumByIdDTO(Long forumId) {
        this.forumId = forumId;
    }

    public static GetForumByIdDTO create(Long forumId) {

        if (forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (forumId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new GetForumByIdDTO(forumId);
    }

}
