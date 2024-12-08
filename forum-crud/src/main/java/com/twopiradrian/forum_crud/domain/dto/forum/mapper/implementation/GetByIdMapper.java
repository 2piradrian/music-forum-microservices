package com.twopiradrian.forum_crud.domain.dto.forum.mapper.implementation;


import com.twopiradrian.forum_crud.domain.dto.forum.request.GetByIdRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.forum.response.GetByIdResponseDTO;
import com.twopiradrian.forum_crud.domain.entity.Forum;

import java.util.Map;

public class GetByIdMapper {

    public GetByIdRequestDTO toRequest(Map<String, Object> payload) {
        return GetByIdRequestDTO.create(
                (Long) payload.get("forumId")
        );
    }

    public GetByIdResponseDTO toResponse(Forum forum) {
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
