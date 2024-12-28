package com.twopiradrian.forum_crud.presentation.service;

import com.twopiradrian.forum_crud.domain.dto.forum.request.*;
import com.twopiradrian.forum_crud.domain.dto.forum.response.CreateForumRes;
import com.twopiradrian.forum_crud.domain.dto.forum.response.EditForumRes;
import com.twopiradrian.forum_crud.domain.dto.forum.response.GetForumByIdRes;
import com.twopiradrian.forum_crud.domain.dto.forum.response.GetForumPageRes;

public interface ForumService {

    GetForumByIdRes getById(GetForumByIdReq dto);

    GetForumPageRes getForums(GetForumPageReq dto);

    CreateForumRes create(CreateForumReq dto);

    EditForumRes edit(EditForumReq dto);

    void toggleVotes(ToggleForumVotesReq dto);

    void delete(DeleteForumReq dto);

}
