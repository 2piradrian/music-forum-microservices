package com.twopiradrian.report_ms.domain.dto.forum.request;

import com.twopiradrian.report_ms.domain.error.ErrorHandler;
import com.twopiradrian.report_ms.domain.error.ErrorType;

import lombok.Getter;

@Getter
public class UpdateForumUpvotersReq {

    private final Long userId;

    private final Long forumId;

    private UpdateForumUpvotersReq(Long userId, Long forumId) {
        this.userId = userId;
        this.forumId = forumId;
    }

    public static UpdateForumUpvotersReq create(Long userId, Long forumId) {

        if (userId == null || forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (userId < 0 || forumId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new UpdateForumUpvotersReq(userId, forumId);
    }
}
