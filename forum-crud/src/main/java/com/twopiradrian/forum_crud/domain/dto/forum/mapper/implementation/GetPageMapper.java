package com.twopiradrian.forum_crud.domain.dto.forum.mapper.implementation;

import com.twopiradrian.entity.Forum;
import com.twopiradrian.entity.PageContent;
import com.twopiradrian.forum_crud.domain.dto.forum.request.GetForumPageReq;
import com.twopiradrian.forum_crud.domain.dto.forum.response.GetForumPageRes;

public class GetPageMapper {

    public GetForumPageReq toRequest(String category, Integer page, Integer size) {
        return GetForumPageReq.create(
                category,
                page,
                size
        );
    }

    public GetForumPageRes toResponse(PageContent<Forum> forums) {
        return new GetForumPageRes(
                forums.getContent(),
                forums.getPage(),
                forums.getNextPage()
        );
    }

}
