package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.data.postgres.mapper.UserEntityMapper;
import com.twopiradrian.forum_crud.data.postgres.model.UserModel;
import com.twopiradrian.forum_crud.data.postgres.repository.PostgresUserRepository;
import com.twopiradrian.forum_crud.domain.entity.User;
import com.twopiradrian.forum_crud.domain.repository.UserRepository;
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

    @Override
    public void save(User user) {
        UserModel userModel = UserEntityMapper.toModel(user);
        userRepository.save(userModel);
    }

    @Override
    public void update(User user) {
        UserModel userModel = UserEntityMapper.toModel(user);
        userRepository.save(userModel);
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

}
