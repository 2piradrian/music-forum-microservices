package com.twopiradrian.report_ms.dto.user.mapper.implementation;



import com.twopiradrian.forum_crud.domain.dto.user.request.GetUserByIdReq;
import com.twopiradrian.forum_crud.domain.dto.user.response.GetUserByIdRes;
import com.twopiradrian.forum_crud.domain.entity.User;

import java.util.Map;

public class GetByIdMapper {

    public GetUserByIdReq toRequest(Map<String, Object> payload) {
        return GetUserByIdReq.create(
                (Long) payload.get("userId")
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
