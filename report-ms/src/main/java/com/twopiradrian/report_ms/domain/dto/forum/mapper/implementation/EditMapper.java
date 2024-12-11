package com.twopiradrian.report_ms.domain.dto.forum.mapper.implementation;

import com.twopiradrian.report_ms.domain.dto.forum.request.EditForumReq;
import com.twopiradrian.report_ms.domain.dto.forum.response.EditForumRes;
import com.twopiradrian.report_ms.domain.models.Forum;

import java.util.Map;

public class EditMapper {

    public EditForumReq toRequest(Map<String, Object> payload) {
        return EditForumReq.create(
                (String) payload.get("title"),
                (String) payload.get("content"),
                (String) payload.get("category"),
                (Long) payload.get("authorId"),
                (Long) payload.get("forumId")
        );
    }

    public EditForumRes toResponse(Forum forum) {
        return new EditForumRes(
            forum.getId()
        );
    }

}
