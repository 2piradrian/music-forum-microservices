package com.twopiradrian.report_ms.domain.dto.forum.mapper;


import com.twopiradrian.report_ms.domain.dto.forum.mapper.implementation.*;

public class ForumMapper {

    public static CreateMapper create() {
        return new CreateMapper();
    }

    public static DeleteMapper delete() {
        return new DeleteMapper();
    }

    public static EditMapper edit() {
        return new EditMapper();
    }

    public static GetByIdMapper getById() {
        return new GetByIdMapper();
    }

    public static UpdateUpvotersMapper updateUpvoters() {
        return new UpdateUpvotersMapper();
    }

}
