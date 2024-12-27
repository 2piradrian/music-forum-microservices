package com.twopiradrian.forum_crud.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forum {

    private String id;

    private String title;

    private String content;

    private Integer views;

    private String authorId;

    private Set<String> upvoters;

    private Category category;

    private List<Comment> comments;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
