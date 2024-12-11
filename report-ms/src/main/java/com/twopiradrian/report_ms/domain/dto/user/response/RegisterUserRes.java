package com.twopiradrian.report_ms.domain.dto.user.response;

import com.twopiradrian.report_ms.domain.models.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@AllArgsConstructor
public class RegisterUserRes {

    private final Long userId;

    private final String username;

    private final String email;

    private final Set<Role> roles;

    private final LocalDateTime memberSince;

    private final LocalDateTime lastLogin;

}
