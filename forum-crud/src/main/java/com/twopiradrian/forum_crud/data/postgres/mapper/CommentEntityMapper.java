package com.twopiradrian.forum_crud.data.postgres.mapper;

import com.twopiradrian.forum_crud.data.postgres.model.CommentModel;
import com.twopiradrian.forum_crud.domain.entity.Comment;

import java.util.stream.Collectors;

public class CommentEntityMapper {

    public static Comment toDomain(CommentModel commentModel) {
        return new Comment(
                commentModel.getId(),
                commentModel.getAuthorId(),
                ForumEntityMapper.toDomain(commentModel.getForum()),
                commentModel.getReplyTo() != null ? toDomain(commentModel.getReplyTo()) : null,
                commentModel.getContent(),
                commentModel.getLikedBy(),
                commentModel.getCreatedAt()
        );
    }

    public static CommentModel toModel(Comment comment) {
        return new CommentModel(
                comment.getId(),
                comment.getAuthorId(),
                ForumEntityMapper.toModel(comment.getForum()),
                comment.getReplyTo() != null ? toModel(comment.getReplyTo()) : null,
                comment.getContent(),
                comment.getLikedBy(),
                comment.getCreatedAt()
        );
    }
}
