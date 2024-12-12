package com.twopiradrian.report_ms.domain.dto.forum.mapper.implementation;

import com.twopiradrian.report_ms.domain.dto.forum.request.GetForumByIdReq;
import com.twopiradrian.report_ms.domain.dto.forum.response.GetForumByIdRes;
import com.twopiradrian.report_ms.domain.models.Forum;

import java.util.Map;

public class GetByIdMapper {

    public GetForumByIdReq toRequest(Long forumId) {
        return GetForumByIdReq.create(
                forumId
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
