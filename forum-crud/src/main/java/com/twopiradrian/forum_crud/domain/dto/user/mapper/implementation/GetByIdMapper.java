package com.twopiradrian.forum_crud.domain.dto.user.mapper.implementation;



import com.twopiradrian.forum_crud.domain.dto.user.request.GetByIdRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.user.response.GetByIdResponseDTO;
import com.twopiradrian.forum_crud.domain.entity.User;

import java.util.Map;

public class GetByIdMapper {

    public GetByIdRequestDTO toRequest(Map<String, Object> payload) {
        return GetByIdRequestDTO.create(
                (Long) payload.get("userId")
        );
    }

    public GetByIdResponseDTO toResponse(User user) {
        return new GetByIdResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRoles(),
                user.getMemberSince(),
                user.getLastLogin()
        );
    }

}
