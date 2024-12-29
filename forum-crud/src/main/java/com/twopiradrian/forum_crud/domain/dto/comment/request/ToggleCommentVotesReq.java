package com.twopiradrian.forum_crud.domain.dto.comment.request;

import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import com.twopiradrian.forum_crud.domain.entity.Vote;
import lombok.Getter;

@Getter
public class ToggleCommentVotesReq {

    private final String token;

    private final String voteType;

    private final String commentId;

    private ToggleCommentVotesReq(String token, String voteType, String commentId) {
        this.token = token;
        this.voteType = voteType;
        this.commentId = commentId;
    }

    public static ToggleCommentVotesReq create(String token, String voteType, String commentId) {

        if (token == null) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        if (voteType == null || commentId == null) {
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

        return new ToggleCommentVotesReq(token, voteType, commentId);
    }

}
