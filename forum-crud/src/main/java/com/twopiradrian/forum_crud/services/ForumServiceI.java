package com.twopiradrian.forum_crud.services;

import com.twopiradrian.forum_crud.entities.Comment;
import com.twopiradrian.forum_crud.entities.Forum;
import com.twopiradrian.forum_crud.entities.User;
import com.twopiradrian.forum_crud.repositories.ForumRepository;
import com.twopiradrian.forum_crud.repositories.UserRepository;
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
    public Forum create(Forum forum) {

        if (forum.getAuthor() == null) {
            throw new IllegalArgumentException("Author is required");
        }
        else if (forum.getCategory() == null) {
            throw new IllegalArgumentException("Category is required");
        }
        else if (forum.getTitle() == null || forum.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title is required");
        }
        else if (forum.getContent() == null || forum.getContent().isEmpty()) {
            throw new IllegalArgumentException("Content is required");
        }

        forum.setViews(0L);
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
