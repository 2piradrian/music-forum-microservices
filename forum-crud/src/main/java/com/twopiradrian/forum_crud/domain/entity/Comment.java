package com.twopiradrian.forum_crud.domain.entity;

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

    private Long authorId;

    private Forum forum;

    private Comment replyTo;

    private String content;

    private Set<Long> likedBy;

    private LocalDateTime createdAt;

}
