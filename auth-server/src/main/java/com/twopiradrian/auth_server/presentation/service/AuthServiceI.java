package com.twopiradrian.auth_server.presentation.service;

import com.twopiradrian.auth_server.config.helpers.JWTHelper;
import com.twopiradrian.auth_server.domain.entity.Token;
import com.twopiradrian.auth_server.domain.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceI implements AuthService {

    private final PasswordEncoder passwordEncoder;

    private final JWTHelper jwtHelper;

    @Override
    public Boolean validatePassword(User user, String password) {

        return this.passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public Token createToken(User user) {
        return new Token(this.jwtHelper.createToken(user));
    }

    @Override
    public String validateToken(String token) {
        if (this.jwtHelper.validateToken(token)) {
            return token;
        }
        
        return null;
    }

}
