package com.twopiradrian.forum_crud.dto.user.mapper;

import com.twopiradrian.forum_crud.dto.user.response.GetByIdResponseDTO;
import com.twopiradrian.forum_crud.entity.User;

public class GetByIdMapper {

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
