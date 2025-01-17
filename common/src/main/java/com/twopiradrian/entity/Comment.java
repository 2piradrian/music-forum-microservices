package com.twopiradrian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private String id;

    private String authorId;

    private String forumId;

    private Comment replyTo;

    private String content;

    private Set<String> upvoters;

    private Set<String> downvoters;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Status status;

}
