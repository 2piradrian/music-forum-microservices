package com.twopiradrian.forum_crud.dto.forum.response;

import com.twopiradrian.forum_crud.entity.Category;
import com.twopiradrian.forum_crud.entity.Comment;
import com.twopiradrian.forum_crud.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class GetByIdResponseDTO {

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
