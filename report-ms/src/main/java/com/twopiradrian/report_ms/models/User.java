package com.twopiradrian.report_ms.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class User {

    private Long id;

    private String username;

    private String password;

    private String email;

    private LocalDateTime memberSince;

    private LocalDateTime lastLogin;

    private Set<Role> roles;

    private Set<Forum> posts;

}