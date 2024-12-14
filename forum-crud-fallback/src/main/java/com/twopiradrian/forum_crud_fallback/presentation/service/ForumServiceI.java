package com.twopiradrian.forum_crud_fallback.presentation.service;

import com.twopiradrian.forum_crud_fallback.data.repository.ForumRepositoryI;
import com.twopiradrian.forum_crud_fallback.data.repository.UserRepositoryI;
import com.twopiradrian.forum_crud_fallback.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.forum_crud_fallback.domain.dto.forum.request.GetForumByIdReq;
import com.twopiradrian.forum_crud_fallback.domain.dto.forum.response.GetForumByIdRes;
import com.twopiradrian.forum_crud_fallback.domain.entity.Forum;
import com.twopiradrian.forum_crud_fallback.domain.error.ErrorHandler;
import com.twopiradrian.forum_crud_fallback.domain.error.ErrorType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@AllArgsConstructor
public class ForumServiceI implements ForumService {

    private final ForumRepositoryI forumRepository;

    @Override
    public GetForumByIdRes getById(GetForumByIdReq dto) {
        Forum forum = this.forumRepository.getById(dto.getForumId());

        if(forum == null) {
            throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);
        }

        return ForumMapper.getById().toResponse(forum);
    }

}
