package com.twopiradrian.report_ms.domain.dto.forum.mapper.implementation;

import com.twopiradrian.report_ms.domain.dto.forum.request.DeleteForumReq;

import java.util.Map;

public class DeleteMapper {

    public DeleteForumReq toRequest(Map<String, Object> payload) {
        return DeleteForumReq.create(
                (Long) payload.get("forumId")
        );
    }

}
