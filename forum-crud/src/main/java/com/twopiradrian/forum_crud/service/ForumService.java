package com.twopiradrian.forum_crud.service;

import com.twopiradrian.forum_crud.dto.forum.request.*;
import com.twopiradrian.forum_crud.dto.forum.response.CreateResponseDTO;
import com.twopiradrian.forum_crud.dto.forum.response.EditResponseDTO;
import com.twopiradrian.forum_crud.dto.forum.response.GetByIdResponseDTO;
import com.twopiradrian.forum_crud.entity.Forum;

public interface ForumService {

    GetByIdResponseDTO getById(GetByIdRequestDTO dto);

    CreateResponseDTO create(CreateRequestDTO dto);

    EditResponseDTO edit(EditRequestDTO dto);

    void updateUpvoters(UpdateUpvotersRequestDTO dto);

    void delete(DeleteRequestDTO dto);
}
