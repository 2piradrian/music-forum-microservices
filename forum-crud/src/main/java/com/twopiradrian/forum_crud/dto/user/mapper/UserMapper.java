package com.twopiradrian.forum_crud.dto.user.mapper;

import com.twopiradrian.forum_crud.dto.user.mapper.implementation.GetByIdMapper;
import com.twopiradrian.forum_crud.dto.user.mapper.implementation.RegisterMapper;

public class UserMapper {

    public static GetByIdMapper getById() {
        return new GetByIdMapper();
    }

    public static RegisterMapper register() {
        return new RegisterMapper();
    }

}
