package com.twopiradrian.forum_crud.domain.dto.forum.mapper.implementation;


import com.twopiradrian.forum_crud.domain.dto.forum.request.EditRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.forum.response.EditResponseDTO;
import com.twopiradrian.forum_crud.domain.entity.Forum;

import java.util.Map;

public class EditMapper {

    public EditRequestDTO toRequest(Map<String, Object> payload) {
        return EditRequestDTO.create(
                (String) payload.get("title"),
                (String) payload.get("content"),
                (String) payload.get("category"),
                (Long) payload.get("authorId"),
                (Long) payload.get("forumId")
        );
    }

    public EditResponseDTO toResponse(Forum forum) {
        return new EditResponseDTO(
            forum.getId()
        );
    }

}
