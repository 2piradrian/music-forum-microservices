package com.twopiradrian.report_ms.domain.dto.forum.mapper.implementation;

import com.twopiradrian.report_ms.domain.dto.forum.request.UpdateForumUpvotersReq;

import java.util.Map;

public class UpdateUpvotersMapper {

    public UpdateForumUpvotersReq toRequest(Map<String, Object> payload) {
        return UpdateForumUpvotersReq.create(
                (Long) payload.get("userId"),
                (Long) payload.get("forumId")
        );
    }

}
