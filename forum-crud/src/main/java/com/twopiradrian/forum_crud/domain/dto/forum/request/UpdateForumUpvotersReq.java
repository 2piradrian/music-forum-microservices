package com.twopiradrian.forum_crud.domain.dto.forum.request;

import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.domain.error.ErrorType;
import lombok.Getter;

@Getter
public class UpdateForumUpvotersReq {

    private final String token;

    private final Long userId;

    private final Long forumId;

    private UpdateForumUpvotersReq(String token, Long userId, Long forumId) {
        this.token = token;
        this.userId = userId;
        this.forumId = forumId;
    }

    public static UpdateForumUpvotersReq create(String token, Long userId, Long forumId) {

        if (token == null) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        if (userId == null || forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (userId < 0 || forumId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new UpdateForumUpvotersReq(token, userId, forumId);
    }
}
