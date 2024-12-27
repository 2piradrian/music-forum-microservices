package com.twopiradrian.auth_server.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;

    private String username;

    private String password;

    private String email;

    private LocalDateTime memberSince;

    private LocalDateTime lastLogin;

    private Set<Role> roles;

}