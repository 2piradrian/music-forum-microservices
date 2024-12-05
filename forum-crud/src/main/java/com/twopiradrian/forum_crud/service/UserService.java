package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.dto.user.request.DeleteUserDTO;
import com.twopiradrian.forum_crud.dto.user.request.GetByIdRequestDTO;
import com.twopiradrian.forum_crud.dto.user.request.LoginUserDTO;
import com.twopiradrian.forum_crud.dto.user.request.RegisterRequestDTO;
import com.twopiradrian.forum_crud.dto.user.response.GetByIdResponseDTO;
import com.twopiradrian.forum_crud.dto.user.response.RegisterResponseDTO;
import com.twopiradrian.forum_crud.entity.User;

public interface UserService {

    GetByIdResponseDTO getById(GetByIdRequestDTO dto);

    RegisterResponseDTO register(RegisterRequestDTO dto);

    User login(LoginUserDTO dto);

    void delete(DeleteUserDTO dto);

}
