package com.twopiradrian.forum_crud.domain.dto.forum.request;

import com.twopiradrian.forum_crud.domain.entity.Vote;
import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.domain.error.ErrorType;
import lombok.Getter;

@Getter
public class ToggleForumVotesReq {

    private final String token;

    private final String voteType;

    private final String forumId;

    private ToggleForumVotesReq(String token, String voteType, String forumId) {
        this.token = token;
        this.voteType = voteType;
        this.forumId = forumId;
    }

    public static ToggleForumVotesReq create(String token, String voteType, String forumId) {

        if (token == null) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        if (voteType == null || forumId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        boolean isValidVote = false;
        for (Vote c : Vote.values()) {
            if (c.name().equals(voteType)) {
                isValidVote = true;
                break;
            }
        }
        if (!isValidVote) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new ToggleForumVotesReq(token, voteType, forumId);
    }
}
