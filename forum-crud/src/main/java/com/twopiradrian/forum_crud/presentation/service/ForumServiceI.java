package com.twopiradrian.forum_crud.presentation.service;

import com.twopiradrian.forum_crud.data.repository.AuthRepositoryI;
import com.twopiradrian.forum_crud.data.repository.ForumRepositoryI;
import com.twopiradrian.forum_crud.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.forum_crud.domain.dto.forum.request.*;
import com.twopiradrian.forum_crud.domain.dto.forum.response.*;
import com.twopiradrian.forum_crud.domain.entity.Category;
import com.twopiradrian.forum_crud.domain.entity.Forum;
import com.twopiradrian.forum_crud.domain.entity.TokenClaims;
import com.twopiradrian.forum_crud.domain.entity.User;
import com.twopiradrian.forum_crud.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud.domain.error.ErrorType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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

        Long views = forum.getViews();
        forum.setViews(views + 1);

        forumRepository.update(forum);

        return ForumMapper.getById().toResponse(forum, author);
    }

    @Override
    public CreateForumRes create(CreateForumReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        log.info("claims: {}", claims);

        Forum forum = new Forum();

        forum.setAuthorId(claims.getId());
        forum.setTitle(dto.getTitle());
        forum.setContent(dto.getContent());
        forum.setCategory(Category.valueOf(dto.getCategory()));

        forum.setViews(0L);
        forum.setUpvoters(Set.of());
        forum.setComments(List.of());
        forum.setCreatedAt(java.time.LocalDateTime.now());
        forum.setUpdatedAt(java.time.LocalDateTime.now());

        Forum saved = forumRepository.save(forum);

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

        forumRepository.update(forum);
        return ForumMapper.edit().toResponse(forum);
    }

    @Override
    public void updateUpvoters(UpdateForumUpvotersReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Forum forum = this.forumRepository.getById(dto.getForumId());
        if (forum == null) throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);

        Set<Long> upvoters = forum.getUpvoters();
        Long user = claims.getId();

        if (upvoters.contains(user)) {
            upvoters.remove(user);
        }
        else {
            upvoters.add(user);
        }

        forumRepository.update(forum);
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

        forumRepository.deleteById(dto.getForumId());
    }
}
