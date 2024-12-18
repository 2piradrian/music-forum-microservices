package com.twopiradrian.forum_crud.domain.dto.user.mapper.implementation;



import com.twopiradrian.forum_crud.domain.dto.user.request.GetUserByIdReq;
import com.twopiradrian.forum_crud.domain.dto.user.response.GetUserByIdRes;
import com.twopiradrian.forum_crud.domain.entity.User;

import java.util.Map;

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
