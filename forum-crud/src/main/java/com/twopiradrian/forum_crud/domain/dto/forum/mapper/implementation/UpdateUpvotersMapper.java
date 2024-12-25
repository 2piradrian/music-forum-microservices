package com.twopiradrian.forum_crud.domain.dto.forum.mapper.implementation;


import com.twopiradrian.forum_crud.domain.dto.forum.request.UpdateForumUpvotersReq;

import java.util.Map;

public class UpdateUpvotersMapper {

    public UpdateForumUpvotersReq toRequest(String token, Map<String, Object> payload) {
        return UpdateForumUpvotersReq.create(
                token,
                (Long) payload.get("userId"),
                (Long) payload.get("forumId")
        );
    }

}
