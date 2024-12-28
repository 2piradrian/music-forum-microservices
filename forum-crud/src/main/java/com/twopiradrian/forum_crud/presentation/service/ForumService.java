package com.twopiradrian.forum_crud.presentation.service;

import com.twopiradrian.forum_crud.domain.dto.forum.request.CreateForumReq;
import com.twopiradrian.forum_crud.domain.dto.forum.request.EditForumReq;
import com.twopiradrian.forum_crud.domain.dto.forum.request.ToggleForumVotesReq;
import com.twopiradrian.forum_crud.domain.dto.forum.response.CreateForumRes;
import com.twopiradrian.forum_crud.domain.dto.forum.response.EditForumRes;
import com.twopiradrian.forum_crud.domain.dto.forum.request.DeleteForumReq;
import com.twopiradrian.forum_crud.domain.dto.forum.request.GetForumByIdReq;
import com.twopiradrian.forum_crud.domain.dto.forum.response.GetForumByIdRes;

public interface ForumService {

    GetForumByIdRes getById(GetForumByIdReq dto);

    CreateForumRes create(CreateForumReq dto);

    EditForumRes edit(EditForumReq dto);

    void toggleVotes(ToggleForumVotesReq dto);

    void delete(DeleteForumReq dto);

}
