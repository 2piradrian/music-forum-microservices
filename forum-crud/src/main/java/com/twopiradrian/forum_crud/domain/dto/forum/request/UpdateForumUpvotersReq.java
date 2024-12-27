package com.twopiradrian.forum_crud.domain.dto.forum.request;

import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.domain.error.ErrorType;
import lombok.Getter;

@Getter
public class UpdateForumUpvotersReq {

    private final String token;

    private final String userId;

    private final String forumId;

    private UpdateForumUpvotersReq(String token, String userId, String forumId) {
        this.token = token;
        this.userId = userId;
        this.forumId = forumId;
    }

    public static UpdateForumUpvotersReq create(String token, String userId, String forumId) {

        if (token == null) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        if (userId == null || forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        return new UpdateForumUpvotersReq(token, userId, forumId);
    }
}
