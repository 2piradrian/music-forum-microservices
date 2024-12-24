package com.twopiradrian.forum_crud.data.postgres.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class CommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long authorId;

    @ManyToOne
    private ForumModel forum;

    @ManyToOne
    private CommentModel replyTo;

    private String content;

    @ManyToMany
    private Set<Long> likedBy;

    private LocalDateTime createdAt;

}
