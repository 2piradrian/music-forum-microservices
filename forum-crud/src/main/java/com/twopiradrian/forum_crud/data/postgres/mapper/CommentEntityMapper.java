package com.twopiradrian.forum_crud.data.postgres.mapper;

import com.twopiradrian.forum_crud.data.postgres.model.CommentModel;
import com.twopiradrian.forum_crud.domain.entity.Comment;

public class CommentEntityMapper {

    public static Comment toDomain(CommentModel commentModel) {
        return new Comment(
                commentModel.getId(),
                commentModel.getAuthorId(),
                commentModel.getForumId(),
                commentModel.getReplyTo() != null ? toDomain(commentModel.getReplyTo()) : null,
                commentModel.getContent(),
                commentModel.getUpvoters(),
                commentModel.getDownvoters(),
                commentModel.getCreatedAt(),
                commentModel.getUpdatedAt(),
                commentModel.getStatus()
        );
    }

    public static CommentModel toModel(Comment comment) {
        return new CommentModel(
                comment.getId(),
                comment.getAuthorId(),
                comment.getForumId(),
                comment.getReplyTo() != null ? toModel(comment.getReplyTo()) : null,
                comment.getContent(),
                comment.getUpvoters(),
                comment.getDownvoters(),
                comment.getCreatedAt(),
                comment.getUpdatedAt(),
                comment.getStatus()
        );
    }
}
