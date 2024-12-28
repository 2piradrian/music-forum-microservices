package com.twopiradrian.forum_crud.presentation.controller;

import com.twopiradrian.forum_crud.domain.dto.comment.mapper.CommentMapper;
import com.twopiradrian.forum_crud.domain.dto.comment.request.*;
import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.presentation.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/get-comments")
    public ResponseEntity<?> getByForumId(
            @RequestParam(value = "forumId") String forumId,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "page") Integer page
    ) {
        try {
            GetCommentPageReq dto = CommentMapper.getPage().toRequest(forumId, size, page);

            return ResponseEntity.ok(this.commentService.getComments(dto));
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
            CreateCommentReq dto = CommentMapper.create().toRequest(token, payload);

            return ResponseEntity.ok(this.commentService.create(dto));
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
            EditCommentReq dto = CommentMapper.edit().toRequest(token, payload);

            return ResponseEntity.ok(this.commentService.edit(dto));
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
            ToggleCommentVotesReq dto = CommentMapper.toggleVotes().toRequest(token, payload);
            this.commentService.toggleVotes(dto);

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
            DeleteCommentReq dto = CommentMapper.delete().toRequest(token, payload);
            this.commentService.delete(dto);

            return ResponseEntity.ok().build();
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
    }

}
