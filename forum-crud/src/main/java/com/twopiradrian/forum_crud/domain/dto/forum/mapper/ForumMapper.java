package com.twopiradrian.forum_crud.domain.dto.forum.mapper;


import com.twopiradrian.forum_crud.domain.dto.forum.mapper.implementation.*;

public class ForumMapper {

    public static CreateMapper create() {
        return new CreateMapper();
    }

    public static GetPageMapper getPage() {
        return new GetPageMapper();
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

    public static ToggleVotesMapper toggleVotes() {
        return new ToggleVotesMapper();
    }

}
