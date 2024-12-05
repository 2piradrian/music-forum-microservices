package com.twopiradrian.forum_crud.dto.forum;

import lombok.Getter;

@Getter
public class CreateForumDTO {

    private final String title;

    private final String description;

    private final String category;

    private final Long authorId;

    private CreateForumDTO(String title, String description, String category, Long authorId) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.authorId = authorId;
    }

    static CreateForumDTO create(String title, String description, String category, Long authorId) {

        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title is required");
        }

        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description is required");
        }

        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category is required");
        }

        if (authorId == null) {
            throw new IllegalArgumentException("Author is required");
        }


        return new CreateForumDTO(title, description, category, authorId);
    }

}
