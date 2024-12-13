package com.twopiradrian.forum_crud.domain.entity;

import com.twopiradrian.forum_crud.data.postgres.model.CommentModel;
import com.twopiradrian.forum_crud.data.postgres.model.ForumModel;
import com.twopiradrian.forum_crud.data.postgres.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Long id;

    private User author;

    private Forum forum;

    private Comment replyTo;

    private String content;

    private Set<User> likedBy;

    private LocalDateTime createdAt;

}
