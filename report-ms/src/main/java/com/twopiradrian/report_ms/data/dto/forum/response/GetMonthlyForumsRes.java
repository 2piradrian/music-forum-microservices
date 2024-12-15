package com.twopiradrian.report_ms.data.dto.forum.response;

import com.twopiradrian.report_ms.domain.entity.Forum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetMonthlyForumsRes {

    private final List<Forum> forums;

}
