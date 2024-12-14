package com.twopiradrian.forum_crud_fallback.data.postgres.mapper;

import com.twopiradrian.forum_crud_fallback.data.postgres.model.CommentModel;
import com.twopiradrian.forum_crud_fallback.domain.entity.Comment;

import java.util.stream.Collectors;

public class CommentEntityMapper {

    public static Comment toDomain(CommentModel commentModel) {
        return new Comment(
                commentModel.getId(),
                UserEntityMapper.toDomain(commentModel.getAuthor()),
                ForumEntityMapper.toDomain(commentModel.getForum()),
                commentModel.getReplyTo() != null ? toDomain(commentModel.getReplyTo()) : null,
                commentModel.getContent(),
                commentModel.getLikedBy().stream().map(UserEntityMapper::toDomain).collect(Collectors.toSet()),
                commentModel.getCreatedAt()
        );
    }

    public static CommentModel toModel(Comment comment) {
        return new CommentModel(
                comment.getId(),
                UserEntityMapper.toModel(comment.getAuthor()),
                ForumEntityMapper.toModel(comment.getForum()),
                comment.getReplyTo() != null ? toModel(comment.getReplyTo()) : null,
                comment.getContent(),
                comment.getLikedBy().stream().map(UserEntityMapper::toModel).collect(Collectors.toSet()),
                comment.getCreatedAt()
        );
    }
}
