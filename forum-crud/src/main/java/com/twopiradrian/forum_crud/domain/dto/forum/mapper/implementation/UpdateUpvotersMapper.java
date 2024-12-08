package com.twopiradrian.forum_crud.domain.dto.forum.mapper.implementation;


import com.twopiradrian.forum_crud.domain.dto.forum.request.UpdateUpvotersRequestDTO;

import java.util.Map;

public class UpdateUpvotersMapper {

    public UpdateUpvotersRequestDTO toRequest(Map<String, Object> payload) {
        return UpdateUpvotersRequestDTO.create(
                (Long) payload.get("userId"),
                (Long) payload.get("forumId")
        );
    }

}
