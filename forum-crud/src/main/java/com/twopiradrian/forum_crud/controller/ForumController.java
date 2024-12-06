package com.twopiradrian.forum_crud.controller;

import com.twopiradrian.forum_crud.dto.forum.mapper.*;
import com.twopiradrian.forum_crud.dto.forum.request.*;
import com.twopiradrian.forum_crud.service.ForumService;
import com.twopiradrian.forum_crud.utils.ErrorHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/forum")
public class ForumController {

    private final ForumService forumService;

    @GetMapping("/get-by-id")
    public ResponseEntity<?> getById(@RequestBody Map<String, Object> payload) {
        try {
            GetByIdRequestDTO dto = GetByIdMapper.toRequest(payload);

            return ResponseEntity.ok(this.forumService.getById(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Map<String, Object> payload) {
        try {
            CreateRequestDTO dto = CreateMapper.toRequest(payload);

            return ResponseEntity.ok(this.forumService.create(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    @PatchMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody Map<String, Object> payload) {
        try {
            EditRequestDTO dto = EditMapper.toRequest(payload);

            return ResponseEntity.ok(this.forumService.edit(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    @PatchMapping("/update-upvoters")
    public ResponseEntity<?> updateUpvoters(@RequestBody Map<String, Object> payload) {
        try {
            UpdateUpvotersRequestDTO dto = UpdateUpvotersMapper.toRequest(payload);
            this.forumService.updateUpvoters(dto);

            return ResponseEntity.ok().build();
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody Map<String, Object> payload) {
        try {
            DeleteRequestDTO dto = DeleteMapper.toRequest(payload);
            this.forumService.delete(dto);

            return ResponseEntity.ok().build();
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }


}
