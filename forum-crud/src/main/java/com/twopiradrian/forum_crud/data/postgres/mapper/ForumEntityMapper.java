package com.twopiradrian.forum_crud.data.postgres.mapper;

import com.twopiradrian.forum_crud.data.postgres.model.ForumModel;
import com.twopiradrian.forum_crud.domain.entity.Forum;

public class ForumEntityMapper {

    public static Forum toDomain(ForumModel forumModel) {
        return new Forum(
                forumModel.getId(),
                forumModel.getTitle(),
                forumModel.getContent(),
                forumModel.getViews(),
                forumModel.getAuthorId(),
                forumModel.getUpvoters(),
                forumModel.getDownvoters(),
                forumModel.getCategory(),
                forumModel.getCreatedAt(),
                forumModel.getUpdatedAt(),
                forumModel.getStatus()
        );
    }

    public static ForumModel toModel(Forum forum) {
        return new ForumModel(
                forum.getId(),
                forum.getTitle(),
                forum.getContent(),
                forum.getViews(),
                forum.getAuthorId(),
                forum.getUpvoters(),
                forum.getDownvoters(),
                forum.getCategory(),
                forum.getCreatedAt(),
                forum.getUpdatedAt(),
                forum.getStatus()
        );
    }

}
