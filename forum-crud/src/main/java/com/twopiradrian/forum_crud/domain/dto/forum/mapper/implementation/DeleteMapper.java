package com.twopiradrian.forum_crud.domain.dto.forum.mapper.implementation;


import com.twopiradrian.forum_crud.domain.dto.forum.request.DeleteRequestDTO;

import java.util.Map;

public class DeleteMapper {

    public DeleteRequestDTO toRequest(Map<String, Object> payload) {
        return DeleteRequestDTO.create(
                (Long) payload.get("forumId")
        );
    }

}
