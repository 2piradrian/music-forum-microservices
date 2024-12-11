package com.twopiradrian.report_ms.domain.dto.user.mapper;


import com.twopiradrian.report_ms.domain.dto.user.mapper.implementation.GetByIdMapper;
import com.twopiradrian.report_ms.domain.dto.user.mapper.implementation.RegisterMapper;

public class UserMapper {

    public static GetByIdMapper getById() {
        return new GetByIdMapper();
    }

    public static RegisterMapper register() {
        return new RegisterMapper();
    }

}
