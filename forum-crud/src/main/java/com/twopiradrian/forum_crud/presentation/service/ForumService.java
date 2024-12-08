package com.twopiradrian.forum_crud.presentation.service;

import com.twopiradrian.forum_crud.domain.dto.forum.request.CreateRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.forum.request.EditRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.forum.request.UpdateUpvotersRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.forum.response.CreateResponseDTO;
import com.twopiradrian.forum_crud.domain.dto.forum.response.EditResponseDTO;
import com.twopiradrian.forum_crud.domain.dto.forum.request.DeleteRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.forum.request.GetByIdRequestDTO;
import com.twopiradrian.forum_crud.domain.dto.forum.response.GetByIdResponseDTO;

public interface ForumService {

    GetByIdResponseDTO getById(GetByIdRequestDTO dto);

    CreateResponseDTO create(CreateRequestDTO dto);

    EditResponseDTO edit(EditRequestDTO dto);

    void updateUpvoters(UpdateUpvotersRequestDTO dto);

    void delete(DeleteRequestDTO dto);
}
