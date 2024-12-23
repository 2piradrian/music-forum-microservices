package com.twopiradrian.forum_crud.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class TokenClaims {

    private final Long userId;

    private final String email;

    private final Set<Role> role;

}
