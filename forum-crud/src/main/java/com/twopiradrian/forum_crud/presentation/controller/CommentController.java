package com.twopiradrian.forum_crud.presentation.controller;

import com.twopiradrian.forum_crud.domain.dto.comment.mapper.CommentMapper;
import com.twopiradrian.forum_crud.domain.dto.comment.request.CreateCommentReq;
import com.twopiradrian.forum_crud.domain.dto.comment.request.DeleteCommentReq;
import com.twopiradrian.forum_crud.domain.dto.comment.request.EditCommentReq;
import com.twopiradrian.forum_crud.domain.dto.comment.request.ToggleCommentVotesReq;
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

    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestHeader("Authorization") String token,
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
            @RequestHeader("Authorization") String token,
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
            @RequestHeader("Authorization") String token,
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
            @RequestHeader("Authorization") String token,
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
