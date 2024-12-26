package com.twopiradrian.forum_crud.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class TokenClaims {

    private final Long id;

    private final String email;

    private final Set<Role> roles;

}
