package com.twopiradrian.forum_crud.controller;

import com.twopiradrian.forum_crud.dto.forum.*;
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
            GetForumByIdDTO dto = GetForumByIdDTO.create(
                    (Long) payload.get("forumId")
            );

            return ResponseEntity.ok(this.forumService.getById(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Map<String, Object> payload) {
        try {
            CreateForumDTO dto = CreateForumDTO.create(
                    (String) payload.get("title"),
                    (String) payload.get("description"),
                    (String) payload.get("category"),
                    (Long) payload.get("authorId")
            );

            return ResponseEntity.ok(this.forumService.create(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    @PatchMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody Map<String, Object> payload) {
        try {
            EditForumDTO dto = EditForumDTO.create(
                    (String) payload.get("title"),
                    (String) payload.get("content"),
                    (String) payload.get("category"),
                    (Long) payload.get("authorId"),
                    (Long) payload.get("forumId")
            );

            return ResponseEntity.ok(this.forumService.edit(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }

    @PatchMapping("/update-upvoters")
    public ResponseEntity<?> updateUpvoters(@RequestBody Map<String, Object> payload) {
        try {
            UpdateForumUpvotersDTO dto = UpdateForumUpvotersDTO.create(
                    (Long) payload.get("userId"),
                    (Long) payload.get("forumId")
            );

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
            DeleteForumDTO dto = DeleteForumDTO.create(
                    (Long) payload.get("forumId")
            );

            this.forumService.delete(dto);
            return ResponseEntity.ok().build();
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }


}
