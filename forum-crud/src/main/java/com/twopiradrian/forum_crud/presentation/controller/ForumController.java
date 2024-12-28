package com.twopiradrian.forum_crud.presentation.controller;

import com.twopiradrian.forum_crud.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.forum_crud.domain.dto.forum.request.*;
import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.presentation.service.ForumService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/forum")
public class ForumController {

    private final ForumService forumService;

    @GetMapping("/get-by-id/{forumId}")
    public ResponseEntity<?> getById(
            @PathVariable(value = "forumId") String forumId
    ) {
        try {
            GetForumByIdReq dto = ForumMapper.getById().toRequest(forumId);

            return ResponseEntity.ok(this.forumService.getById(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
    }

    @GetMapping("/get-forums")
    public ResponseEntity<?> getForums(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "page") Integer page
    ) {
        try {
            GetForumPageReq dto = ForumMapper.getPage().toRequest(category, size, page);

            return ResponseEntity.ok(this.forumService.getForums(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody Map<String, Object> payload
    ) {
        try {
            CreateForumReq dto = ForumMapper.create().toRequest(token, payload);

            return ResponseEntity.ok(this.forumService.create(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
    }

    @PatchMapping("/edit")
    public ResponseEntity<?> edit(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody Map<String, Object> payload
    ) {
        try {
            EditForumReq dto = ForumMapper.edit().toRequest(token, payload);

            return ResponseEntity.ok(this.forumService.edit(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
    }

    @PatchMapping("/toggle-votes")
    public ResponseEntity<?> toggleVotes(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody Map<String, Object> payload
    ) {
        try {
            ToggleForumVotesReq dto = ForumMapper.toggleVotes().toRequest(token, payload);
            this.forumService.toggleVotes(dto);

            return ResponseEntity.ok().build();
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody Map<String, Object> payload
    ) {
        try {
            DeleteForumReq dto = ForumMapper.delete().toRequest(token, payload);
            this.forumService.delete(dto);

            return ResponseEntity.ok().build();
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
    }

}
