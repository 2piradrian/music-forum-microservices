package com.twopiradrian.forum_crud_fallback.domain.dto.forum.mapper;


import com.twopiradrian.forum_crud_fallback.domain.dto.forum.mapper.implementation.GetByIdMapper;

public class ForumMapper {

    public static GetByIdMapper getById() {
        return new GetByIdMapper();
    }


}
