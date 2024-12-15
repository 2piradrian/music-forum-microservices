package com.twopiradrian.report_ms.domain.dto.forum.response;

import com.twopiradrian.report_ms.domain.entity.Forum;
import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
public class MakeMonthlyForumReportRes {

    private final String report;

}
