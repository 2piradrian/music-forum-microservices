package com.twopiradrian.report_ms.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class Comment {

    private Long id;

    private User author;

    private Forum forum;

    private Comment replyTo;

    private String content;

    private Set<User> likedBy;

    private LocalDateTime createdAt;

}
