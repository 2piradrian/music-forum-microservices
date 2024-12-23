package com.twopiradrian.auth_server.presentation.service;

import com.twopiradrian.auth_server.data.repository.UserRepositoryI;
import com.twopiradrian.auth_server.domain.dto.user.mapper.UserMapper;
import com.twopiradrian.auth_server.domain.dto.user.request.*;
import com.twopiradrian.auth_server.domain.dto.user.response.LoginUserRes;
import com.twopiradrian.auth_server.domain.dto.user.response.GetUserByIdRes;
import com.twopiradrian.auth_server.domain.dto.user.response.RegisterUserRes;
import com.twopiradrian.auth_server.domain.dto.user.response.AuthUserRes;
import com.twopiradrian.auth_server.domain.entity.Role;
import com.twopiradrian.auth_server.domain.entity.Token;
import com.twopiradrian.auth_server.domain.entity.User;
import com.twopiradrian.auth_server.domain.error.ErrorHandler;
import com.twopiradrian.auth_server.domain.error.ErrorType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceI implements UserService {

    private final UserRepositoryI userRepository;

    private final AuthServiceI authService;

    @Override
    public GetUserByIdRes getById(GetUserByIdReq dto) {
        User user = this.userRepository.getById(dto.getUserId());
        if (user == null) throw new ErrorHandler(ErrorType.USER_NOT_FOUND);

        return UserMapper.getById().toResponse(user);
    }

    @Override
    public RegisterUserRes register(RegisterUserReq dto) {
        var emailCheck = this.userRepository.getByEmail(dto.getEmail());
        if (emailCheck != null) throw new ErrorHandler(ErrorType.EMAIL_ALREADY_EXISTS);

        var usernameCheck = this.userRepository.getByUsername(dto.getUsername());
        if (usernameCheck != null) throw new ErrorHandler(ErrorType.USERNAME_ALREADY_EXISTS);

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRoles(Set.of(Role.USER));
        user.setMemberSince(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());

        this.userRepository.save(user);

        return UserMapper.register().toResponse(user);
    }

    @Override
    public LoginUserRes login(LoginUserReq dto) {
        User user = this.userRepository.getByEmail(dto.getEmail());
        if (user == null) throw new ErrorHandler(ErrorType.USER_NOT_FOUND);

        if (!this.authService.validatePassword(user, dto.getPassword())) {
            throw new ErrorHandler(ErrorType.INVALID_PASSWORD);
        }

        Token token = this.authService.createToken(user);

        return UserMapper.login().toResponse(token);
    }

    @Override
    public AuthUserRes auth(AuthUserReq dto) {
        String token = this.authService.validateToken(dto.getAccessToken());

        if (token == null) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        String subject = this.authService.getSubject(token);
        User user = this.userRepository.getByEmail(subject);

        if (user == null) {
            throw new ErrorHandler(ErrorType.USER_NOT_FOUND);
        }

        return UserMapper.auth().toResponse(user);
    }

    @Override
    public void delete(DeleteUserReq dto) {
        String token = this.authService.validateToken(dto.getToken());

        if (token == null) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        String subject = this.authService.getSubject(token);
        User user = this.userRepository.getByEmail(subject);

        if (user == null) {
            throw new ErrorHandler(ErrorType.USER_NOT_FOUND);
        }

        this.userRepository.deleteById(user.getId());
    }

}
