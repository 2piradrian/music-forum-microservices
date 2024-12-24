package com.twopiradrian.forum_crud.domain.dto.forum.request;

import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.domain.error.ErrorType;
import lombok.Getter;

@Getter
public class DeleteForumReq {

    private final String token;

    private final Long forumId;

    private DeleteForumReq(String token, Long forumId) {
        this.token = token;
        this.forumId = forumId;
    }

    public static DeleteForumReq create(String token, Long forumId) {

        if (token == null) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        if (forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (forumId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new DeleteForumReq(token, forumId);
    }
}
