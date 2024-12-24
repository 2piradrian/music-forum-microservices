package com.twopiradrian.auth_server.presentation.service;

import com.twopiradrian.auth_server.data.repository.UserRepositoryI;
import com.twopiradrian.auth_server.domain.dto.user.mapper.UserMapper;
import com.twopiradrian.auth_server.domain.dto.user.request.*;
import com.twopiradrian.auth_server.domain.dto.user.response.CredentialsLoginUserRes;
import com.twopiradrian.auth_server.domain.dto.user.response.GetUserByIdRes;
import com.twopiradrian.auth_server.domain.dto.user.response.RegisterUserRes;
import com.twopiradrian.auth_server.domain.dto.user.response.TokenLoginUserRes;
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
        user.setMemberSince(LocalDateTime.now());
        user.setLastLogin(LocalDateTime.now());

        this.userRepository.save(user);

        return UserMapper.register().toResponse(user);
    }

    @Override
    public CredentialsLoginUserRes credentialsLogin(CredentialsLoginUserReq dto) {
        User userFromDB = this.userRepository.getByEmail(dto.getEmail());

        if (userFromDB == null) {
            throw new ErrorHandler(ErrorType.USER_NOT_FOUND);
        }

        if (!this.authService.validatePassword(userFromDB, dto.getPassword())) {
            throw new ErrorHandler(ErrorType.INVALID_PASSWORD);
        }

        final var token = this.authService.createToken(userFromDB);

        return UserMapper.credentialsLogin().toResponse(token);
    }

    @Override
    public TokenLoginUserRes tokenLoginUser(TokenLoginUserReq dto) {
        final var validatedToken = this.authService.validateToken(dto.getAccessToken());

        Token token = new Token();
        token.setAccessToken(validatedToken);

        return UserMapper.tokenLogin().toResponse(token);
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
