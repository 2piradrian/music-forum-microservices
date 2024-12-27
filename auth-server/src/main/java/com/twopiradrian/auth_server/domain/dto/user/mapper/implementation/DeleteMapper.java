package com.twopiradrian.auth_server.domain.dto.user.mapper.implementation;

import com.twopiradrian.auth_server.domain.dto.user.request.AuthUserReq;
import com.twopiradrian.auth_server.domain.dto.user.request.DeleteUserReq;
import com.twopiradrian.auth_server.domain.dto.user.response.AuthUserRes;
import com.twopiradrian.auth_server.domain.entity.User;

public class DeleteMapper {

    public DeleteUserReq toRequest(String accessToken) {
        return DeleteUserReq.create(
                accessToken
        );
    }

}
