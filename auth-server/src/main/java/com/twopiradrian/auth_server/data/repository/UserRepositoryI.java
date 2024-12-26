package com.twopiradrian.auth_server.data.repository;

import com.twopiradrian.auth_server.data.postgres.mapper.UserEntityMapper;
import com.twopiradrian.auth_server.data.postgres.model.UserModel;
import com.twopiradrian.auth_server.data.postgres.repository.PostgresUserRepository;
import com.twopiradrian.auth_server.domain.entity.User;
import com.twopiradrian.auth_server.domain.repository.UserRepository;
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
    public User getByEmail(String email) {
        UserModel userModel = userRepository.findByEmail(email).orElse(null);
        return userModel != null ? UserEntityMapper.toDomain(userModel) : null;
    }

    @Override
    public User getByUsername(String username) {
        UserModel userModel = userRepository.findByUsername(username).orElse(null);
        return userModel != null ? UserEntityMapper.toDomain(userModel) : null;
    }

    @Override
    public User save(User user) {
        UserModel userModel = UserEntityMapper.toModel(user);
        UserModel saved = userRepository.save(userModel);

        return UserEntityMapper.toDomain(saved);
    }

    @Override
    public User update(User user) {
        UserModel userModel = UserEntityMapper.toModel(user);
        UserModel updated = userRepository.save(userModel);

        return UserEntityMapper.toDomain(updated);
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

}
