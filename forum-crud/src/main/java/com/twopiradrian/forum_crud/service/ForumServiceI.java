package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.dto.forum.*;
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
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class ForumServiceI implements ForumService {

    private final ForumRepository forumRepository;
    private final UserRepository userRepository;

    @Override
    public Forum getById(GetForumByIdDTO dto) {
        Forum existingForum = this.forumRepository.findById(dto.getForumId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.FORUM_NOT_FOUND));

        Long views = existingForum.getViews();
        existingForum.setViews(views + 1);

        forumRepository.save(existingForum);

        return existingForum;
    }

    @Override
    public Forum create(CreateForumDTO dto) {
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

        return forumRepository.save(forum);
    }

    @Override
    public Forum edit(EditForumDTO dto) {
        Forum existingForum = this.forumRepository.findById(dto.getForumId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.FORUM_NOT_FOUND));

        existingForum.setTitle(dto.getTitle());
        existingForum.setContent(dto.getContent());
        existingForum.setCategory(Category.valueOf(dto.getCategory()));

        return forumRepository.save(existingForum);
    }

    @Override
    public void updateUpvoters(UpdateForumUpvotersDTO dto) {
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
    public void delete(DeleteForumDTO dto) {
        Forum forum = this.forumRepository.findById(dto.getForumId())
                .orElseThrow(() -> new ErrorHandler(ErrorType.FORUM_NOT_FOUND));

        forumRepository.delete(forum);
    }
}
