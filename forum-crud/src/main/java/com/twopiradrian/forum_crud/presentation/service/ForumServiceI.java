package com.twopiradrian.forum_crud.presentation.service;

import com.twopiradrian.forum_crud.data.repository.AuthRepositoryI;
import com.twopiradrian.forum_crud.data.repository.ForumRepositoryI;
import com.twopiradrian.forum_crud.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.forum_crud.domain.dto.forum.request.*;
import com.twopiradrian.forum_crud.domain.dto.forum.response.*;
import com.twopiradrian.forum_crud.domain.entity.*;
import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.domain.error.ErrorType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class ForumServiceI implements ForumService {

    private final ForumRepositoryI forumRepository;
    private final AuthRepositoryI authRepository;

    @Override
    public GetForumByIdRes getById(GetForumByIdReq dto) {
        Forum forum = this.forumRepository.getById(dto.getForumId());
        if(forum == null) throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);

        User author = this.authRepository.getById(forum.getAuthorId());
        if(author == null) throw new ErrorHandler(ErrorType.USER_NOT_FOUND);

        Integer views = forum.getViews();
        forum.setViews(views + 1);

        this.forumRepository.update(forum);

        return ForumMapper.getById().toResponse(forum, author);
    }

    @Override
    public GetForumPageRes getForums(GetForumPageReq dto) {
        PageContent<Forum> forums =
                this.forumRepository.getAllForums(dto.getPage(), dto.getSize(), dto.getCategory());

        return ForumMapper.getPage().toResponse(forums);
    }

    @Override
    public CreateForumRes create(CreateForumReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Forum forum = new Forum();

        forum.setAuthorId(claims.getId());
        forum.setTitle(dto.getTitle());
        forum.setContent(dto.getContent());
        forum.setCategory(Category.valueOf(dto.getCategory()));
        forum.setStatus(Status.ACTIVE);

        forum.setViews(0);
        forum.setUpvoters(Set.of());
        forum.setDownvoters(Set.of());
        forum.setCreatedAt(LocalDateTime.now());
        forum.setUpdatedAt(LocalDateTime.now());

        Forum saved = this.forumRepository.save(forum);

        return ForumMapper.create().toResponse(saved);
    }

    @Override
    public EditForumRes edit(EditForumReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Forum forum = this.forumRepository.getById(dto.getForumId());
        if (forum == null) throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);

        if (!forum.getAuthorId().equals(claims.getId())) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        forum.setTitle(dto.getTitle());
        forum.setContent(dto.getContent());
        forum.setCategory(Category.valueOf(dto.getCategory()));
        forum.setUpdatedAt(LocalDateTime.now());

        Forum edited = this.forumRepository.update(forum);
        return ForumMapper.edit().toResponse(edited);
    }

    @Override
    public void toggleVotes(ToggleForumVotesReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Forum forum = this.forumRepository.getById(dto.getForumId());
        if (forum == null) throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);

        String user = claims.getId();

        Set<String> upvoters = forum.getUpvoters();
        Set<String> downvoters = forum.getDownvoters();

        if (Objects.equals(Vote.UPVOTE.toString(), dto.getVoteType())) {
            if (upvoters.contains(user)) {
                upvoters.remove(user);
            } else {
                upvoters.add(user);
                downvoters.remove(user);
            }
        }
        if (Objects.equals(Vote.DOWNVOTE.toString(), dto.getVoteType())) {
            if (downvoters.contains(user)) {
                downvoters.remove(user);
            } else {
                downvoters.add(user);
                upvoters.remove(user);
            }
        }

        forum.setUpvoters(upvoters);
        forum.setDownvoters(downvoters);

        this.forumRepository.update(forum);
    }

    @Override
    public void delete(DeleteForumReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Forum forum = this.forumRepository.getById(dto.getForumId());
        if (forum == null) throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);

        if (!forum.getAuthorId().equals(claims.getId())) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        forum.setUpdatedAt(LocalDateTime.now());
        forum.setStatus(Status.DELETED);

        this.forumRepository.update(forum);
    }

}
