package com.twopiradrian.auth_server.domain.dto.user.response;

import com.twopiradrian.auth_server.domain.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class AuthUserRes {

    private final Long id;

    private final String email;

    private final Set<Role> roles;

}
