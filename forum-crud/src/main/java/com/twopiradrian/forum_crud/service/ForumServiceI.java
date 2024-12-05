package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.dto.forum.CreateForumDTO;
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
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class ForumServiceI implements ForumService {

    private final ForumRepository forumRepository;
    private final UserRepository userRepository;

    @Override
    public Forum getById(Long id) {
        Forum existingForum = this.forumRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Forum with id " + id + " not found"));

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
    public Forum edit(Forum forum) {
        Forum existingForum = forumRepository.findById(forum.getId())
                .orElseThrow(() -> new NoSuchElementException("Forum with id " + forum.getId() + " not found"));

        existingForum.setTitle(forum.getTitle());
        existingForum.setContent(forum.getContent());
        existingForum.setCategory(forum.getCategory());

        return forumRepository.save(existingForum);
    }

    @Override
    public void updateUpvoters(Long forumId, Long userId) {
        Forum existingForum = forumRepository.findById(forumId)
                .orElseThrow(() -> new NoSuchElementException("Forum with id " + forumId + " not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User with id " + userId + " not found"));

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
    public void delete(Long id) {
        Forum forum = forumRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Forum with id " + id + " not found"));

        forumRepository.delete(forum);
    }
}
