package com.twopiradrian.forum_crud.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "forums")
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Long views;

    @ManyToOne
    private User author;

    @ManyToMany
    private Set<User> upvoters;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
