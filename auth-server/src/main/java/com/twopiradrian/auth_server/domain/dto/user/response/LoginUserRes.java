package com.twopiradrian.auth_server.domain.dto.user.response;

import com.twopiradrian.auth_server.domain.entity.Token;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginUserRes {

    private final Token token;

}