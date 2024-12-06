package com.twopiradrian.forum_crud.dto.forum.mapper;

import com.twopiradrian.forum_crud.dto.forum.request.GetByIdRequestDTO;
import com.twopiradrian.forum_crud.dto.forum.response.GetByIdResponseDTO;
import com.twopiradrian.forum_crud.entity.Forum;

import java.util.Map;

public class GetByIdMapper {

    public static GetByIdRequestDTO toRequest(Map<String, Object> payload) {
        return GetByIdRequestDTO.create(
                (Long) payload.get("forumId")
        );
    }

    public static GetByIdResponseDTO toResponse(Forum forum) {
        return new GetByIdResponseDTO(
                forum.getId(),
                forum.getTitle(),
                forum.getContent(),
                forum.getViews(),
                forum.getAuthor(),
                forum.getUpvoters().size(),
                forum.getCategory(),
                forum.getComments(),
                forum.getCreatedAt()
        );
    }
}
