package com.twopiradrian.forum_crud.dto.forum;

import com.twopiradrian.forum_crud.utils.ErrorHandler;
import com.twopiradrian.forum_crud.utils.ErrorType;
import lombok.Getter;

@Getter
public class UpdateForumUpvotersDTO {

    private final Long userId;

    private final Long forumId;

    private UpdateForumUpvotersDTO(Long userId, Long forumId) {
        this.userId = userId;
        this.forumId = forumId;
    }

    public static UpdateForumUpvotersDTO create(Long userId, Long forumId) {

        if (userId == null || forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (userId < 0 || forumId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new UpdateForumUpvotersDTO(userId, forumId);
    }
}
