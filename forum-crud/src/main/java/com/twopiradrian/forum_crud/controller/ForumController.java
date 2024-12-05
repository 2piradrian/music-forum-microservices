package com.twopiradrian.forum_crud.controller;

import com.twopiradrian.forum_crud.dto.forum.CreateForumDTO;
import com.twopiradrian.forum_crud.service.ForumService;
import com.twopiradrian.forum_crud.utils.ErrorHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/forum")
public class ForumController {

    private final ForumService forumService;

    public ResponseEntity<?> create(@RequestBody Map<String, Object> payload) {
        try {
            CreateForumDTO dto = CreateForumDTO.create(
                    (String) payload.get("title"),
                    (String) payload.get("description"),
                    (String) payload.get("category"),
                    (Long) payload.get("authorId")
            );

            var forumCreated = forumService.create(dto);

            return ResponseEntity.ok(forumCreated);
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.getMessage());
        }
    }
}
