package com.twopiradrian.forum_crud.dto.forum.mapper;

import com.twopiradrian.forum_crud.dto.forum.request.EditRequestDTO;
import com.twopiradrian.forum_crud.dto.forum.response.EditResponseDTO;
import com.twopiradrian.forum_crud.entity.Forum;

import java.util.Map;

public class EditMapper {

    public static EditRequestDTO toRequest(Map<String, Object> payload) {
        return EditRequestDTO.create(
                (String) payload.get("title"),
                (String) payload.get("content"),
                (String) payload.get("category"),
                (Long) payload.get("authorId"),
                (Long) payload.get("forumId")
        );
    }

    public static EditResponseDTO toResponse(Forum forum) {
        return new EditResponseDTO(
            forum.getId()
        );
    }

}
