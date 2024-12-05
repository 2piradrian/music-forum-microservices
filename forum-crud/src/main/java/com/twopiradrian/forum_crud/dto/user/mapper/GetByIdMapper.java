package com.twopiradrian.forum_crud.dto.user.mapper;

import com.twopiradrian.forum_crud.dto.user.request.GetByIdRequestDTO;
import com.twopiradrian.forum_crud.dto.user.response.GetByIdResponseDTO;
import com.twopiradrian.forum_crud.entity.User;

import java.util.Map;

public class GetByIdMapper {

    public static GetByIdRequestDTO toRequest(Map<String, Object> payload) {
        return GetByIdRequestDTO.create(
                (Long) payload.get("userId")
        );
    }

    public static GetByIdResponseDTO toResponse(User user) {
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
