package com.twopiradrian.auth_server.domain.dto.user.mapper.implementation;

import com.twopiradrian.auth_server.domain.dto.user.request.GetUserByIdReq;
import com.twopiradrian.auth_server.domain.dto.user.response.GetUserByIdRes;
import com.twopiradrian.auth_server.domain.entity.User;

public class GetByIdMapper {

    public GetUserByIdReq toRequest(Long userId) {
        return GetUserByIdReq.create(
                userId
        );
    }

    public GetUserByIdRes toResponse(User user) {
        return new GetUserByIdRes(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRoles(),
                user.getMemberSince(),
                user.getLastLogin()
        );
    }

}
