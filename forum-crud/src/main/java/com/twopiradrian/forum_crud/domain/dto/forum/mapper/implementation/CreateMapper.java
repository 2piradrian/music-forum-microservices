package com.twopiradrian.forum_crud.domain.dto.forum.mapper.implementation;

import com.twopiradrian.forum_crud.domain.dto.forum.request.CreateForumReq;
import com.twopiradrian.forum_crud.domain.dto.forum.response.CreateForumRes;
import com.twopiradrian.forum_crud.domain.entity.Forum;

import java.util.Map;

public class CreateMapper {

    public CreateForumReq toRequest(String token, Map<String, Object> payload) {
        return CreateForumReq.create(
                token,
                (String) payload.get("title"),
                (String) payload.get("content"),
                (String) payload.get("category")
        );
    }

    public CreateForumRes toResponse(Forum forum) {
        return new CreateForumRes(
            forum.getId()
        );
    }

}
