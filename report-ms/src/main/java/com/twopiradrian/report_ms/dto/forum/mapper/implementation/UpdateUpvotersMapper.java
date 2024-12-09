package com.twopiradrian.report_ms.dto.forum.mapper.implementation;


import com.twopiradrian.forum_crud.domain.dto.forum.request.UpdateForumUpvotersReq;

import java.util.Map;

public class UpdateUpvotersMapper {

    public UpdateForumUpvotersReq toRequest(Map<String, Object> payload) {
        return UpdateForumUpvotersReq.create(
                (Long) payload.get("userId"),
                (Long) payload.get("forumId")
        );
    }

}
