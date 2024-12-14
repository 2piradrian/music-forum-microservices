package com.twopiradrian.forum_crud_fallback.presentation.service;

import com.twopiradrian.forum_crud_fallback.data.repository.UserRepositoryI;
import com.twopiradrian.forum_crud_fallback.domain.dto.user.mapper.UserMapper;
import com.twopiradrian.forum_crud_fallback.domain.dto.user.request.GetUserByIdReq;
import com.twopiradrian.forum_crud_fallback.domain.dto.user.response.GetUserByIdRes;
import com.twopiradrian.forum_crud_fallback.domain.entity.User;
import com.twopiradrian.forum_crud_fallback.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud_fallback.domain.error.ErrorType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


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

}
