package com.twopiradrian.forum_crud.dto.forum.mapper;

import com.twopiradrian.forum_crud.dto.forum.request.UpdateUpvotersRequestDTO;

import java.util.Map;

public class UpdateUpvotersMapper {

    public static UpdateUpvotersRequestDTO toRequest(Map<String, Object> payload) {
        return UpdateUpvotersRequestDTO.create(
                (Long) payload.get("userId"),
                (Long) payload.get("forumId")
        );
    }

}
