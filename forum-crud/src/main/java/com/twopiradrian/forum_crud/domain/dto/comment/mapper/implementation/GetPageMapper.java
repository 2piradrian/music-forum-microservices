package com.twopiradrian.forum_crud.domain.dto.comment.mapper.implementation;

import com.twopiradrian.forum_crud.domain.dto.comment.request.GetCommentPageReq;
import com.twopiradrian.forum_crud.domain.dto.comment.response.GetCommentPageRes;
import com.twopiradrian.forum_crud.domain.entity.Comment;
import com.twopiradrian.forum_crud.domain.entity.PageContent;

import java.util.List;
import java.util.Map;

public class GetPageMapper {

    public GetCommentPageReq toRequest(Map<String, Object> payload) {
        return GetCommentPageReq.create(
                (String) payload.get("forumId"),
                (Integer) payload.get("page"),
                (Integer) payload.get("size")
        );
    }

    public GetCommentPageRes toResponse(PageContent<Comment> comments) {
        return new GetCommentPageRes(
                comments.getContent(),
                comments.getPage(),
                comments.getNextPage()
        );
    }

}
