package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.dto.forum.DeleteForumDTO;
import com.twopiradrian.forum_crud.dto.user.mapper.GetByIdMapper;
import com.twopiradrian.forum_crud.dto.user.mapper.RegisterMapper;
import com.twopiradrian.forum_crud.dto.user.request.GetByIdRequestDTO;
import com.twopiradrian.forum_crud.dto.user.request.LoginUserDTO;
import com.twopiradrian.forum_crud.dto.user.request.RegisterRequestDTO;
import com.twopiradrian.forum_crud.dto.user.response.GetByIdResponseDTO;
import com.twopiradrian.forum_crud.dto.user.response.RegisterResponseDTO;
import com.twopiradrian.forum_crud.entity.User;
import com.twopiradrian.forum_crud.repository.UserRepository;
import com.twopiradrian.forum_crud.utils.ErrorHandler;
import com.twopiradrian.forum_crud.utils.ErrorType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceI implements UserService {

    private final UserRepository userRepository;

    @Override
    public GetByIdResponseDTO getById(GetByIdRequestDTO dto) {
        User existingUser = this.userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.USER_NOT_FOUND));

        return GetByIdMapper.toResponse(existingUser);
    }

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO dto) {
        User user = RegisterMapper.toEntity(dto);

        User savedUser = userRepository.save(user);

        return RegisterMapper.toResponse(savedUser);
    }

    @Override
    public User login(LoginUserDTO dto) {
        return null;
    }

    @Override
    public void delete(DeleteForumDTO dto) {

    }
}
