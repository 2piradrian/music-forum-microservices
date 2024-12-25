package com.twopiradrian.auth_server.presentation.service;

import com.twopiradrian.auth_server.domain.entity.Token;
import com.twopiradrian.auth_server.domain.entity.User;

public interface AuthService {

    String hashPassword(String password);

    Boolean validatePassword(User user, String password);

    String validateToken(String token);

    String getSubject(String token);

    Token createToken(User user);

}
