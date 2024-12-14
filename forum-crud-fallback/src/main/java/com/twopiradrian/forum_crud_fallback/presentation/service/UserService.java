package com.twopiradrian.forum_crud_fallback.presentation.service;

import com.twopiradrian.forum_crud_fallback.domain.dto.user.request.GetUserByIdReq;
import com.twopiradrian.forum_crud_fallback.domain.dto.user.response.GetUserByIdRes;

public interface UserService {

    GetUserByIdRes getById(GetUserByIdReq dto);

}
