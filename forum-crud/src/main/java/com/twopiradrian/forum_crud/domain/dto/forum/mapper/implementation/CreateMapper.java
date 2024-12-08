package com.twopiradrian.forum_crud.domain.dto.forum.mapper.implementation;


import com.twopiradrian.forum_crud.domain.dto.forum.request.CreateRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.forum.response.CreateResponseDTO;
import com.twopiradrian.forum_crud.domain.entity.Forum;

import java.util.Map;

public class CreateMapper {

    public CreateRequestDTO toRequest(Map<String, Object> payload) {
        return CreateRequestDTO.create(
                (String) payload.get("title"),
                (String) payload.get("content"),
                (String) payload.get("category"),
                (Long) payload.get("authorId")
        );
    }

    public CreateResponseDTO toResponse(Forum forum) {
        return new CreateResponseDTO(
            forum.getId()
        );
    }

}
