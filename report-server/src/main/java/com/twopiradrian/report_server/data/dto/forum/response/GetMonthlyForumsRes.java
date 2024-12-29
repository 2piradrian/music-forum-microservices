package com.twopiradrian.report_server.data.dto.forum.response;

import com.twopiradrian.entity.Forum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetMonthlyForumsRes {

    private final List<Forum> forums;

}
