package com.twopiradrian.forum_crud.dto.forum;

import com.twopiradrian.forum_crud.entity.Category;
import com.twopiradrian.forum_crud.utils.ErrorHandler;
import com.twopiradrian.forum_crud.utils.ErrorType;
import lombok.Getter;

@Getter
public class CreateForumDTO {

    private final String title;

    private final String content;

    private final String category;

    private final Long authorId;

    private CreateForumDTO(String title, String content, String category, Long authorId) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.authorId = authorId;
    }

    public static CreateForumDTO create(String title, String content, String category, Long authorId) {

        if (title == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        title = title.trim();
        if (title.isEmpty() || title.length() > 256) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        if (content == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        content = content.trim();
        if (content.isEmpty() || content.length() > 4096) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        if (category == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        boolean isValidCategory = false;
        for (Category c : Category.values()) {
            if (c.name().equals(category)) {
                isValidCategory = true;
                break;
            }
        }
        if (!isValidCategory) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        if (authorId == null) {
            throw new ErrorHandler(ErrorType.MISSING_REQUIRED_FIELDS);
        }

        if (authorId < 0) {
            throw new ErrorHandler(ErrorType.INVALID_FIELDS);
        }

        return new CreateForumDTO(title, content, category, authorId);
    }

}