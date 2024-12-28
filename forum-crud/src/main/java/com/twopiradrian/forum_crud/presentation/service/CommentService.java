package com.twopiradrian.forum_crud.presentation.service;

import com.twopiradrian.forum_crud.domain.dto.comment.request.*;
import com.twopiradrian.forum_crud.domain.dto.comment.response.CreateCommentRes;
import com.twopiradrian.forum_crud.domain.dto.comment.response.EditCommentRes;
import com.twopiradrian.forum_crud.domain.dto.comment.response.GetCommentPageRes;

public interface CommentService {

    GetCommentPageRes getComments(GetCommentPageReq dto);

    CreateCommentRes create(CreateCommentReq dto);

    EditCommentRes edit(EditCommentReq dto);

    void toggleVotes(ToggleCommentVotesReq dto);

    void delete(DeleteCommentReq dto);

}
