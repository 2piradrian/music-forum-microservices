package com.twopiradrian.auth_server.presentation.service;

import com.twopiradrian.auth_server.domain.entity.Token;
import com.twopiradrian.auth_server.domain.entity.User;

public interface AuthService {

    Boolean validatePassword(User user, String password);

    Token validateToken(Token token);

    Token createToken(User user);
}
