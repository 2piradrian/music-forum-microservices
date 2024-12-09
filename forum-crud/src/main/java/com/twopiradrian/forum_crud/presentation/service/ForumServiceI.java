package com.twopiradrian.forum_crud.presentation.service;

import com.twopiradrian.forum_crud.data.repository.ForumRepository;
import com.twopiradrian.forum_crud.data.repository.UserRepository;
import com.twopiradrian.forum_crud.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.forum_crud.domain.dto.forum.request.*;
import com.twopiradrian.forum_crud.domain.dto.forum.response.*;
import com.twopiradrian.forum_crud.domain.entity.Category;
import com.twopiradrian.forum_crud.domain.entity.Forum;
import com.twopiradrian.forum_crud.domain.entity.User;
import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.domain.error.ErrorType;
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
    public GetForumByIdRes getById(GetForumByIdReq dto) {
        Forum existingForum = this.forumRepository.findById(dto.getForumId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.FORUM_NOT_FOUND));

        Long views = existingForum.getViews();
        existingForum.setViews(views + 1);

        forumRepository.save(existingForum);

        return ForumMapper.getById().toResponse(existingForum);
    }

    @Override
    public CreateForumRes create(CreateForumReq dto) {
        User author = this.userRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.USER_NOT_FOUND));

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
        Forum savedForum = forumRepository.save(forum);

        return ForumMapper.create().toResponse(savedForum);
    }

    @Override
    public EditForumRes edit(EditForumReq dto) {
        Forum existingForum = this.forumRepository.findById(dto.getForumId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.FORUM_NOT_FOUND));

        existingForum.setTitle(dto.getTitle());
        existingForum.setContent(dto.getContent());
        existingForum.setCategory(Category.valueOf(dto.getCategory()));

        Forum editedForum = forumRepository.save(existingForum);
        return ForumMapper.edit().toResponse(editedForum);
    }

    @Override
    public void updateUpvoters(UpdateForumUpvotersReq dto) {
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
    public void delete(DeleteForumReq dto) {
        Forum forum = this.forumRepository.findById(dto.getForumId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.FORUM_NOT_FOUND));

        forumRepository.delete(forum);
    }
}
