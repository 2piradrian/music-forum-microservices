package com.twopiradrian.forum_crud.data.repository;

import com.twopiradrian.forum_crud.data.postgres.PostgresUserRepository;
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
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }

}
