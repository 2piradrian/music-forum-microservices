package com.twopiradrian.report_ms.dto.forum.mapper.implementation;


import com.twopiradrian.forum_crud.domain.dto.forum.request.GetForumByIdReq;
import com.twopiradrian.forum_crud.domain.dto.forum.response.GetForumByIdRes;
import com.twopiradrian.forum_crud.domain.entity.Forum;

import java.util.Map;

public class GetByIdMapper {

    public GetForumByIdReq toRequest(Map<String, Object> payload) {
        return GetForumByIdReq.create(
                (Long) payload.get("forumId")
        );
    }

    public GetForumByIdRes toResponse(Forum forum) {
        return new GetForumByIdRes(
                forum.getId(),
                forum.getTitle(),
                forum.getContent(),
                forum.getViews(),
                forum.getAuthor(),
                forum.getUpvoters().size(),
                forum.getCategory(),
                forum.getComments(),
                forum.getCreatedAt()
        );
    }
}
