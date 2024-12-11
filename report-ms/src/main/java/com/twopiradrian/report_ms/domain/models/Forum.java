package com.twopiradrian.report_ms.domain.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class Forum {

    private Long id;

    private String title;

    private String content;

    private Long views;

    private User author;

    private Set<User> upvoters;

    private Category category;

    private List<Comment> comments;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
