package com.twopiradrian.forum_crud.dto.forum.mapper;

import com.twopiradrian.forum_crud.dto.forum.request.CreateRequestDTO;
import com.twopiradrian.forum_crud.dto.forum.response.CreateResponseDTO;
import com.twopiradrian.forum_crud.entity.Category;
import com.twopiradrian.forum_crud.entity.Forum;
import com.twopiradrian.forum_crud.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateMapper {

    public static CreateRequestDTO toRequest(Map<String, Object> payload) {
        return CreateRequestDTO.create(
                (String) payload.get("title"),
                (String) payload.get("content"),
                (String) payload.get("category"),
                (Long) payload.get("authorId")
        );
    }

    public static CreateResponseDTO toResponse(Forum forum) {
        return new CreateResponseDTO(
            forum.getId()
        );
    }

    public static Forum toEntity(CreateRequestDTO dto, User author) {
        Forum forum = new Forum();

        forum.setAuthor(author);
        forum.setTitle(dto.getTitle());
        forum.setContent(dto.getContent());
        forum.setCategory(Category.valueOf(dto.getCategory()));

        forum.setViews(0L);
        forum.setUpvoters(Set.of());
        forum.setComments(List.of());
        forum.setCreatedAt(java.time.LocalDateTime.now());
        forum.setUpdatedAt(java.time.LocalDateTime.now());

        return forum;
    }

}
