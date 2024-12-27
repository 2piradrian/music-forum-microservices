package com.twopiradrian.forum_crud.domain.dto.comment.mapper.implementation;

import com.twopiradrian.forum_crud.domain.dto.comment.request.CreateCommentReq;
import com.twopiradrian.forum_crud.domain.dto.comment.response.CreateCommentRes;
import com.twopiradrian.forum_crud.domain.entity.Comment;

import java.util.Map;

public class CreateMapper {

    public CreateCommentReq toRequest(String token, Map<String, Object> payload) {
        return CreateCommentReq.create(
                token,
                (String) payload.get("forumId"),
                (String) payload.get("content"),
                (String) payload.get("replyTo")
        );
    }

    public CreateCommentRes toResponse(Comment comment) {
        return new CreateCommentRes(
                comment.getId()
        );
    }

}
