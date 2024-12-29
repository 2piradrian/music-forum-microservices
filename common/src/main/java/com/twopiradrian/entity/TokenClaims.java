package com.twopiradrian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class TokenClaims {

    private final String id;

    private final String email;

    private final Set<Role> roles;

}
