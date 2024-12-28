package com.twopiradrian.forum_crud.domain.dto.forum.response;


import com.twopiradrian.forum_crud.domain.entity.Category;
import com.twopiradrian.forum_crud.domain.entity.Forum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class GetMonthlyForumsRes {

    private final List<Forum> forums;

}
