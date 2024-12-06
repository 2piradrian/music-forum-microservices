package com.twopiradrian.forum_crud.dto.user.mapper.implementation;

import com.twopiradrian.forum_crud.dto.user.request.RegisterRequestDTO;
import com.twopiradrian.forum_crud.dto.user.response.RegisterResponseDTO;
import com.twopiradrian.forum_crud.entity.Role;
import com.twopiradrian.forum_crud.entity.User;

import java.util.Map;
import java.util.Set;

public class RegisterMapper {

    public RegisterRequestDTO toRequest(Map<String, Object> payload) {
        return RegisterRequestDTO.create(
                (String) payload.get("username"),
                (String) payload.get("password"),
                (String) payload.get("email")
        );

    }

    public RegisterResponseDTO toResponse(User user) {
        return new RegisterResponseDTO(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getRoles(),
            user.getMemberSince(),
            user.getLastLogin()
        );
    }

}
