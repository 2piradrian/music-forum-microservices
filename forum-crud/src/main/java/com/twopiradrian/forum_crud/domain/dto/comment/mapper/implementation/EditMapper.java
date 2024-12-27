package com.twopiradrian.forum_crud.domain.dto.comment.mapper.implementation;

import com.twopiradrian.forum_crud.domain.dto.comment.request.EditCommentReq;
import com.twopiradrian.forum_crud.domain.dto.comment.response.EditCommentRes;
import com.twopiradrian.forum_crud.domain.entity.Comment;

import java.util.Map;

public class EditMapper {

    public EditCommentReq toRequest(String token, Map<String, Object> payload) {
        return EditCommentReq.create(
                token,
                (String) payload.get("commentId"),
                (String) payload.get("content")
        );
    }

    public EditCommentRes toResponse(Comment comment) {
        return new EditCommentRes(
            comment.getId()
        );
    }

}
