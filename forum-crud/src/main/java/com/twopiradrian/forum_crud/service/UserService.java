package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.dto.user.request.DeleteRequestDTO;
import com.twopiradrian.forum_crud.dto.user.request.GetByIdRequestDTO;
import com.twopiradrian.forum_crud.dto.user.request.LoginRequestDTO;
import com.twopiradrian.forum_crud.dto.user.request.RegisterRequestDTO;
import com.twopiradrian.forum_crud.dto.user.response.GetByIdResponseDTO;
import com.twopiradrian.forum_crud.dto.user.response.RegisterResponseDTO;
import com.twopiradrian.forum_crud.entity.User;

public interface UserService {

    GetByIdResponseDTO getById(GetByIdRequestDTO dto);

    RegisterResponseDTO register(RegisterRequestDTO dto);

    User login(LoginRequestDTO dto);

    void delete(DeleteRequestDTO dto);

}
