package com.twopiradrian.forum_crud.domain.dto.comment.request;

import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import lombok.Getter;

@Getter
public class GetCommentPageReq {

    private final String forumId;

    private final Integer page;

    private final Integer size;

    private GetCommentPageReq(String forumId, Integer page, Integer size) {
        this.forumId = forumId;
        this.page = page;
        this.size = size;
    }

    public static GetCommentPageReq create(String forumId, Integer page, Integer size) {

        if (forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (page == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (page < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        if (size == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (size < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new GetCommentPageReq(forumId, page, size);
    }

}
