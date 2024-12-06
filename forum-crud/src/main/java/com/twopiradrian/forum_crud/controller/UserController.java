package com.twopiradrian.forum_crud.controller;

import com.twopiradrian.forum_crud.dto.user.mapper.GetByIdMapper;
import com.twopiradrian.forum_crud.dto.user.mapper.RegisterMapper;
import com.twopiradrian.forum_crud.dto.user.request.GetByIdRequestDTO;
import com.twopiradrian.forum_crud.dto.user.request.RegisterRequestDTO;
import com.twopiradrian.forum_crud.dto.user.response.RegisterResponseDTO;
import com.twopiradrian.forum_crud.service.UserService;
import com.twopiradrian.forum_crud.utils.ErrorHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get-by-id")
    public ResponseEntity<?> getById(@RequestBody Map<String, Object> payload) {
        try {
            GetByIdRequestDTO dto = GetByIdMapper.toRequest(payload);

            return ResponseEntity.ok(this.userService.getById(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, Object> payload) {
        try {
            RegisterRequestDTO dto = RegisterMapper.toRequest(payload);

            return ResponseEntity.ok(this.userService.register(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }
}
