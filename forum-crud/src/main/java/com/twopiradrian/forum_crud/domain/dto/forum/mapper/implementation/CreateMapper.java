package com.twopiradrian.forum_crud.domain.dto.forum.mapper.implementation;


import com.twopiradrian.forum_crud.domain.dto.forum.request.CreateForumReq;
import com.twopiradrian.forum_crud.domain.dto.forum.response.CreateForumRes;
import com.twopiradrian.forum_crud.domain.entity.Forum;

import java.util.Map;

public class CreateMapper {

    public CreateForumReq toRequest(Map<String, Object> payload) {
        return CreateForumReq.create(
                (String) payload.get("title"),
                (String) payload.get("content"),
                (String) payload.get("category"),
                (Long) payload.get("authorId")
        );
    }

    public CreateForumRes toResponse(Forum forum) {
        return new CreateForumRes(
            forum.getId()
        );
    }

}
