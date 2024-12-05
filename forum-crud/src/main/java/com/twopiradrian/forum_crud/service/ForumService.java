package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.dto.forum.*;
import com.twopiradrian.forum_crud.entity.Forum;

public interface ForumService {

    Forum getById(GetForumByIdDTO dto);

    Forum create(CreateForumDTO dto);

    Forum edit(EditForumDTO dto);

    void updateUpvoters(UpdateForumUpvotersDTO dto);

    void delete(DeleteForumDTO dto);
}
