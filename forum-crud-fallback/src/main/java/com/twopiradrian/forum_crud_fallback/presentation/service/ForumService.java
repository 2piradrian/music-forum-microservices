package com.twopiradrian.forum_crud_fallback.presentation.service;

import com.twopiradrian.forum_crud_fallback.domain.dto.forum.request.GetForumByIdReq;
import com.twopiradrian.forum_crud_fallback.domain.dto.forum.response.GetForumByIdRes;

public interface ForumService {

    GetForumByIdRes getById(GetForumByIdReq dto);

}
