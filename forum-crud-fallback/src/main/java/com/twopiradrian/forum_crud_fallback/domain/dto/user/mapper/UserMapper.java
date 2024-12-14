package com.twopiradrian.forum_crud_fallback.domain.dto.user.mapper;


import com.twopiradrian.forum_crud_fallback.domain.dto.user.mapper.implementation.GetByIdMapper;

public class UserMapper {

    public static GetByIdMapper getById() {
        return new GetByIdMapper();
    }

}
