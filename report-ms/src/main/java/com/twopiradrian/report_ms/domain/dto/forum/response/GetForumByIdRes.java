package com.twopiradrian.report_ms.domain.dto.forum.response;

import com.twopiradrian.report_ms.domain.models.Category;
import com.twopiradrian.report_ms.domain.models.Comment;
import com.twopiradrian.report_ms.domain.models.User;
import lombok.Getter;
import lombok.AllArgsConstructor;

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
