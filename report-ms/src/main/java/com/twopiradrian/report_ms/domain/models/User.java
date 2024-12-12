package com.twopiradrian.report_ms.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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