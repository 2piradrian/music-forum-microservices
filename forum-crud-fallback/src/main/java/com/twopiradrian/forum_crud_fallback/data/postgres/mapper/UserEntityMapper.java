package com.twopiradrian.forum_crud_fallback.data.postgres.mapper;

import com.twopiradrian.forum_crud_fallback.data.postgres.model.UserModel;
import com.twopiradrian.forum_crud_fallback.domain.entity.User;

import java.util.stream.Collectors;

public class UserEntityMapper {

    public static User toDomain(UserModel userModel) {
        return new User(
                userModel.getId(),
                userModel.getUsername(),
                userModel.getPassword(),
                userModel.getEmail(),
                userModel.getMemberSince(),
                userModel.getLastLogin(),
                userModel.getRoles(),
                userModel.getPosts().stream().map(ForumEntityMapper::toDomain).collect(Collectors.toSet())
        );
    }

    public static UserModel toModel(User user) {
        return new UserModel(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getMemberSince(),
                user.getLastLogin(),
                user.getRoles(),
                user.getPosts().stream().map(ForumEntityMapper::toModel).collect(Collectors.toSet())
        );
    }

}
