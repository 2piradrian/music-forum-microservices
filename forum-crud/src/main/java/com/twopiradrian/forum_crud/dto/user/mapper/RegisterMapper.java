package com.twopiradrian.forum_crud.dto.user.mapper;

import com.twopiradrian.forum_crud.dto.user.request.RegisterRequestDTO;
import com.twopiradrian.forum_crud.dto.user.response.RegisterResponseDTO;
import com.twopiradrian.forum_crud.entity.Role;
import com.twopiradrian.forum_crud.entity.User;

import java.util.Set;

public class RegisterMapper {

    public static RegisterResponseDTO toResponse(User user) {
        return new RegisterResponseDTO(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getRoles(),
            user.getMemberSince(),
            user.getLastLogin()
        );
    }

    public static User toEntity(RegisterRequestDTO dto) {
        User user = new User();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRoles(Set.of(Role.USER));
        user.setMemberSince(java.time.LocalDateTime.now());
        user.setLastLogin(java.time.LocalDateTime.now());

        return user;
    }

}
