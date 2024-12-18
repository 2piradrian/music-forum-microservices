package com.twopiradrian.forum_crud.data.postgres.mapper;

import com.twopiradrian.forum_crud.data.postgres.model.ForumModel;
import com.twopiradrian.forum_crud.domain.entity.Forum;

import java.util.stream.Collectors;

public class ForumEntityMapper {

    public static Forum toDomain(ForumModel forumModel) {
        return new Forum(
                forumModel.getId(),
                forumModel.getTitle(),
                forumModel.getContent(),
                forumModel.getViews(),
                UserEntityMapper.toDomain(forumModel.getAuthor()),
                forumModel.getUpvoters().stream().map(UserEntityMapper::toDomain).collect(Collectors.toSet()),
                forumModel.getCategory(),
                forumModel.getComments().stream().map(CommentEntityMapper::toDomain).collect(Collectors.toList()),
                forumModel.getCreatedAt(),
                forumModel.getUpdatedAt()
        );
    }

    public static ForumModel toModel(Forum forum) {
        return new ForumModel(
                forum.getId(),
                forum.getTitle(),
                forum.getContent(),
                forum.getViews(),
                UserEntityMapper.toModel(forum.getAuthor()),
                forum.getUpvoters().stream().map(UserEntityMapper::toModel).collect(Collectors.toSet()),
                forum.getCategory(),
                forum.getComments().stream().map(CommentEntityMapper::toModel).collect(Collectors.toList()),
                forum.getCreatedAt(),
                forum.getUpdatedAt()
        );
    }

}
