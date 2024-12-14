package com.twopiradrian.forum_crud_fallback.domain.dto.forum.mapper.implementation;


import com.twopiradrian.forum_crud_fallback.domain.dto.forum.request.GetForumByIdReq;
import com.twopiradrian.forum_crud_fallback.domain.dto.forum.response.GetForumByIdRes;
import com.twopiradrian.forum_crud_fallback.domain.entity.Forum;

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
