package com.twopiradrian.forum_crud.domain.dto.forum.response;

import com.twopiradrian.entity.Forum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetForumPageRes {

    List<Forum> forums;

    Integer page;

    Integer nextPage;

}
