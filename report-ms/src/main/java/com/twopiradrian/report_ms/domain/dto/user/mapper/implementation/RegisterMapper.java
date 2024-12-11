package com.twopiradrian.report_ms.domain.dto.user.mapper.implementation;

import com.twopiradrian.report_ms.domain.dto.user.request.RegisterUserReq;
import com.twopiradrian.report_ms.domain.dto.user.response.RegisterUserRes;
import com.twopiradrian.report_ms.domain.models.User;

import java.util.Map;

public class RegisterMapper {

    public RegisterUserReq toRequest(Map<String, Object> payload) {
        return RegisterUserReq.create(
                (String) payload.get("username"),
                (String) payload.get("password"),
                (String) payload.get("email")
        );

    }

    public RegisterUserRes toResponse(User user) {
        return new RegisterUserRes(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getRoles(),
            user.getMemberSince(),
            user.getLastLogin()
        );
    }

}