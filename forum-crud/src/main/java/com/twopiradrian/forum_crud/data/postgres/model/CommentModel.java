package com.twopiradrian.forum_crud.data.postgres.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class CommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String authorId;

    @ManyToOne
    private ForumModel forum;

    @ManyToOne
    private CommentModel replyTo;

    private String content;

    private Set<String> likedBy;

    private LocalDateTime createdAt;

}
