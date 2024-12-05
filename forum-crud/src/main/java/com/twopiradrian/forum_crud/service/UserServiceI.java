package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.dto.forum.DeleteForumDTO;
import com.twopiradrian.forum_crud.dto.forum.GetForumByIdDTO;
import com.twopiradrian.forum_crud.dto.user.LoginUserDTO;
import com.twopiradrian.forum_crud.dto.user.RegisterUserDTO;
import com.twopiradrian.forum_crud.entity.User;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceI implements UserService {


    @Override
    public User getById(GetForumByIdDTO dto) {
        return null;
    }

    @Override
    public User register(RegisterUserDTO dto) {
        return null;
    }

    @Override
    public User login(LoginUserDTO dto) {
        return null;
    }

    @Override
    public void delete(DeleteForumDTO dto) {

    }
}
