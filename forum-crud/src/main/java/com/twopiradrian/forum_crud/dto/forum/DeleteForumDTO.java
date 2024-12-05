package com.twopiradrian.forum_crud.dto.forum;

import com.twopiradrian.forum_crud.utils.ErrorHandler;
import com.twopiradrian.forum_crud.utils.ErrorType;
import lombok.Getter;

@Getter
public class DeleteForumDTO {

    private final Long forumId;

    private DeleteForumDTO(Long forumId) {
        this.forumId = forumId;
    }

    public static DeleteForumDTO create(Long forumId) {

        if (forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (forumId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new DeleteForumDTO(forumId);
    }
}
