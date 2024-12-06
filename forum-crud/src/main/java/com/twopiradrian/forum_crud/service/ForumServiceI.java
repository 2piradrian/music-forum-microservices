package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.dto.forum.mapper.CreateMapper;
import com.twopiradrian.forum_crud.dto.forum.mapper.EditMapper;
import com.twopiradrian.forum_crud.dto.forum.request.*;
import com.twopiradrian.forum_crud.dto.forum.response.CreateResponseDTO;
import com.twopiradrian.forum_crud.dto.forum.response.EditResponseDTO;
import com.twopiradrian.forum_crud.dto.forum.response.GetByIdResponseDTO;
import com.twopiradrian.forum_crud.dto.forum.mapper.GetByIdMapper;
import com.twopiradrian.forum_crud.entity.Category;
import com.twopiradrian.forum_crud.entity.Forum;
import com.twopiradrian.forum_crud.entity.User;
import com.twopiradrian.forum_crud.repository.ForumRepository;
import com.twopiradrian.forum_crud.repository.UserRepository;
import com.twopiradrian.forum_crud.utils.ErrorHandler;
import com.twopiradrian.forum_crud.utils.ErrorType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class ForumServiceI implements ForumService {

    private final ForumRepository forumRepository;
    private final UserRepository userRepository;

    @Override
    public GetByIdResponseDTO getById(GetByIdRequestDTO dto) {
        Forum existingForum = this.forumRepository.findById(dto.getForumId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.FORUM_NOT_FOUND));

        Long views = existingForum.getViews();
        existingForum.setViews(views + 1);

        forumRepository.save(existingForum);

        return GetByIdMapper.toResponse(existingForum);
    }

    @Override
    public CreateResponseDTO create(CreateRequestDTO dto) {
        User author = this.userRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.USER_NOT_FOUND));

        Forum forum = CreateMapper.toEntity(dto, author);
        Forum savedForum = forumRepository.save(forum);

        return CreateMapper.toResponse(savedForum);
    }

    @Override
    public EditResponseDTO edit(EditRequestDTO dto) {
        Forum existingForum = this.forumRepository.findById(dto.getForumId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.FORUM_NOT_FOUND));

        existingForum.setTitle(dto.getTitle());
        existingForum.setContent(dto.getContent());
        existingForum.setCategory(Category.valueOf(dto.getCategory()));

        Forum editedForum = forumRepository.save(existingForum);
        return EditMapper.toResponse(editedForum);
    }

    @Override
    public void updateUpvoters(UpdateUpvotersRequestDTO dto) {
        Forum existingForum = this.forumRepository.findById(dto.getForumId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.FORUM_NOT_FOUND));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.USER_NOT_FOUND));

        Set<User> upvoters = existingForum.getUpvoters();
        if (upvoters.contains(user)) {
            upvoters.remove(user);
        }
        else {
            upvoters.add(user);
        }

        forumRepository.save(existingForum);
    }

    @Override
    public void delete(DeleteRequestDTO dto) {
        Forum forum = this.forumRepository.findById(dto.getForumId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.FORUM_NOT_FOUND));

        forumRepository.delete(forum);
    }
}
