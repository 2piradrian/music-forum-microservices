package com.twopiradrian.forum_crud.presentation.service;

import com.twopiradrian.forum_crud.data.repository.UserRepository;
import com.twopiradrian.forum_crud.domain.dto.user.mapper.UserMapper;
import com.twopiradrian.forum_crud.domain.dto.user.request.DeleteRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.user.request.LoginRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.user.request.RegisterRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.user.response.GetByIdResponseDTO;
import com.twopiradrian.forum_crud.domain.dto.user.request.GetByIdRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.user.response.RegisterResponseDTO;
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

    private final UserRepository userRepository;

    @Override
    public GetByIdResponseDTO getById(GetByIdRequestDTO dto) {
        User existingUser = this.userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.USER_NOT_FOUND));

        return UserMapper.getById().toResponse(existingUser);
    }

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO dto) {

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRoles(Set.of(Role.USER));
        user.setMemberSince(java.time.LocalDateTime.now());
        user.setLastLogin(java.time.LocalDateTime.now());

        User savedUser = userRepository.save(user);

        return UserMapper.register().toResponse(savedUser);
    }

    @Override
    public User login(LoginRequestDTO dto) {
        return null;
    }

    @Override
    public void delete(DeleteRequestDTO dto) {

    }

}
