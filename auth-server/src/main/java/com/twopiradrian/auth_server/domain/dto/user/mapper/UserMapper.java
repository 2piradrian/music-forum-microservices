package com.twopiradrian.auth_server.domain.dto.user.mapper;


import com.twopiradrian.auth_server.domain.dto.user.mapper.implementation.*;

public class UserMapper {

    public static GetByIdMapper getById() {
        return new GetByIdMapper();
    }

    public static RegisterMapper register() {
        return new RegisterMapper();
    }

}
