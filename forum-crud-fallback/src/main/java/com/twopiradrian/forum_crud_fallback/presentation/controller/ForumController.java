package com.twopiradrian.forum_crud_fallback.presentation.controller;

import com.twopiradrian.forum_crud_fallback.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.forum_crud_fallback.domain.dto.forum.request.GetForumByIdReq;
import com.twopiradrian.forum_crud_fallback.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud_fallback.presentation.service.ForumService;
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
    public ResponseEntity<?> getById(@PathVariable Long forumId) {
        try {
            GetForumByIdReq dto = ForumMapper.getById().toRequest(forumId);

            return ResponseEntity.ok(this.forumService.getById(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
    }

}
