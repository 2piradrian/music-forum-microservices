package com.twopiradrian.forum_crud.domain.dto.comment.response;

import com.twopiradrian.forum_crud.domain.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetCommentPageRes {

    List<Comment> comments;

    Integer page;

    Integer nextPage;

}
