package com.twopiradrian.report_ms.domain.dto.forum.request;

import com.twopiradrian.report_ms.domain.error.ErrorHandler;
import com.twopiradrian.report_ms.domain.error.ErrorType;
import lombok.Getter;

@Getter
public class GetForumByIdReq {

    private final Long forumId;

    private GetForumByIdReq(Long forumId) {
        this.forumId = forumId;
    }

    public static GetForumByIdReq create(Long forumId) {

        if (forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (forumId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new GetForumByIdReq(forumId);
    }

}
