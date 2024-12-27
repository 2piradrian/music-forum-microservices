package com.twopiradrian.forum_crud.data.postgres.model;

import com.twopiradrian.forum_crud.domain.entity.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "forums")
public class ForumModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Integer views;

    private String authorId;

    private Set<String> upvoters;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentModel> comments;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
