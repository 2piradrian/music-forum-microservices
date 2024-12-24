package com.twopiradrian.auth_server.presentation.controller;

import com.twopiradrian.auth_server.domain.dto.user.mapper.UserMapper;
import com.twopiradrian.auth_server.domain.dto.user.request.GetUserByIdReq;
import com.twopiradrian.auth_server.domain.dto.user.request.CredentialsLoginUserReq;
import com.twopiradrian.auth_server.domain.dto.user.request.RegisterUserReq;
import com.twopiradrian.auth_server.domain.dto.user.request.TokenLoginUserReq;
import com.twopiradrian.auth_server.domain.error.ErrorHandler;
import com.twopiradrian.auth_server.presentation.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/get-by-id/{userId}")
    public ResponseEntity<?> getById(@PathVariable Long userId) {
        try {
            GetUserByIdReq dto = UserMapper.getById().toRequest(userId);

            return ResponseEntity.ok(this.userService.getById(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> payload) {
        try {
            RegisterUserReq dto = UserMapper.register().toRequest(payload);

            return ResponseEntity.ok(this.userService.register(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
    }

    @PostMapping("/login/credentials")
    public ResponseEntity<?> login(@RequestBody Map<String, Object> payload) {
        try {
            CredentialsLoginUserReq dto = UserMapper.credentialsLogin().toRequest(payload);

            return ResponseEntity.ok(this.userService.credentialsLogin(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
    }

    @GetMapping("/login/token")
    public ResponseEntity<?> login(@RequestHeader("Authorization") String token) {
        try {
            TokenLoginUserReq dto = UserMapper.tokenLogin().toRequest(token);

            return ResponseEntity.ok(this.userService.tokenLoginUser(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
    }
}
