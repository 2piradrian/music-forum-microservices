package com.twopiradrian.forum_crud.domain.dto.forum.mapper.implementation;


import com.twopiradrian.forum_crud.domain.dto.forum.request.GetForumByIdReq;
import com.twopiradrian.forum_crud.domain.dto.forum.response.GetForumByIdRes;
import com.twopiradrian.forum_crud.domain.entity.Forum;
import com.twopiradrian.forum_crud.domain.entity.User;

import java.util.Map;

public class GetByIdMapper {

    public GetForumByIdReq toRequest(Long forumId) {
        return GetForumByIdReq.create(
                forumId
        );
    }

    public GetForumByIdRes toResponse(Forum forum, User author) {
        return new GetForumByIdRes(
                author.getId(),
                author.getUsername(),
                forum.getId(),
                forum.getTitle(),
                forum.getContent(),
                forum.getViews(),
                forum.getUpvoters().size(),
                forum.getCategory(),
                forum.getComments(),
                forum.getCreatedAt()
        );
    }
}
