package com.twopiradrian.forum_crud_fallback.data.repository;

import com.twopiradrian.forum_crud_fallback.data.postgres.mapper.UserEntityMapper;
import com.twopiradrian.forum_crud_fallback.data.postgres.model.UserModel;
import com.twopiradrian.forum_crud_fallback.data.postgres.repository.PostgresUserRepository;
import com.twopiradrian.forum_crud_fallback.domain.entity.User;
import com.twopiradrian.forum_crud_fallback.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepositoryI implements UserRepository {

    private final PostgresUserRepository userRepository;

    @Override
    public User getById(Long userId) {
        UserModel userModel = userRepository.findById(userId).orElse(null);
        return userModel != null ? UserEntityMapper.toDomain(userModel) : null;
    }

}
