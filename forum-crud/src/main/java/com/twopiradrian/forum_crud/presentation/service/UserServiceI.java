package com.twopiradrian.forum_crud.presentation.service;

import com.twopiradrian.forum_crud.data.repository.UserRepositoryI;
import com.twopiradrian.forum_crud.domain.dto.user.mapper.UserMapper;
import com.twopiradrian.forum_crud.domain.dto.user.request.DeleteUserReq;
import com.twopiradrian.forum_crud.domain.dto.user.request.LoginUserReq;
import com.twopiradrian.forum_crud.domain.dto.user.request.RegisterUserReq;
import com.twopiradrian.forum_crud.domain.dto.user.response.GetUserByIdRes;
import com.twopiradrian.forum_crud.domain.dto.user.request.GetUserByIdReq;
import com.twopiradrian.forum_crud.domain.dto.user.response.RegisterUserRes;
import com.twopiradrian.forum_crud.domain.entity.Role;
import com.twopiradrian.forum_crud.domain.entity.User;
import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.domain.error.ErrorType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceI implements UserService {

    private final UserRepositoryI userRepository;

    @Override
    public GetUserByIdRes getById(GetUserByIdReq dto) {
        User user = this.userRepository.getById(dto.getUserId());

        if (user == null) {
            throw new ErrorHandler(ErrorType.USER_NOT_FOUND);
        }

        return UserMapper.getById().toResponse(user);
    }

    @Override
    public RegisterUserRes register(RegisterUserReq dto) {

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRoles(Set.of(Role.USER));
        user.setMemberSince(java.time.LocalDateTime.now());
        user.setLastLogin(java.time.LocalDateTime.now());

        this.userRepository.save(user);

        return UserMapper.register().toResponse(user);
    }

    @Override
    public User login(LoginUserReq dto) {
        return null;
    }

    @Override
    public void delete(DeleteUserReq dto) {
        User user = this.userRepository.getById(dto.getUserId());

        if (user == null) {
            throw new ErrorHandler(ErrorType.USER_NOT_FOUND);
        }

        this.userRepository.deleteById(dto.getUserId());
    }

}
