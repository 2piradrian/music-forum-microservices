package com.twopiradrian.forum_crud_fallback.data.postgres.model;

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
@Builder
@Table(name = "comments")
public class CommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserModel author;

    @ManyToOne
    private ForumModel forum;

    @ManyToOne
    private CommentModel replyTo;

    private String content;

    @ManyToMany
    private Set<UserModel> likedBy;

    private LocalDateTime createdAt;

}
