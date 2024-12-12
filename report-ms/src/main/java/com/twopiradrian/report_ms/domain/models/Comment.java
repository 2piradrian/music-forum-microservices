package com.twopiradrian.report_ms.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
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
