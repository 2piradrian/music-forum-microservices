package com.twopiradrian.report_ms.dto.forum.response;


import com.twopiradrian.forum_crud.domain.entity.Category;
import com.twopiradrian.forum_crud.domain.entity.Comment;
import com.twopiradrian.forum_crud.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class GetForumByIdRes {

    private final Long forumId;

    private final String title;

    private final String content;

    private final Long views;

    private final User author;

    private final int upvoters;

    private final Category category;

    private final List<Comment> comments;

    private final LocalDateTime createdAt;

}
