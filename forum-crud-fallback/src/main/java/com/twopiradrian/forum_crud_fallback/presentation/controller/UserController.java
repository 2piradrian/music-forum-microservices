package com.twopiradrian.forum_crud_fallback.presentation.controller;

import com.twopiradrian.forum_crud_fallback.domain.dto.user.mapper.UserMapper;
import com.twopiradrian.forum_crud_fallback.domain.dto.user.request.GetUserByIdReq;
import com.twopiradrian.forum_crud_fallback.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud_fallback.presentation.service.UserService;
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

}
