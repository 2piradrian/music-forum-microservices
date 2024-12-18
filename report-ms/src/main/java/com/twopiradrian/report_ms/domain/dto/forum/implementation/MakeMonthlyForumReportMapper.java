package com.twopiradrian.report_ms.domain.dto.forum.implementation;

import com.twopiradrian.report_ms.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.report_ms.domain.dto.forum.response.MakeMonthlyForumReportRes;

import java.util.Map;

public class MakeMonthlyForumReportMapper {

    public MakeMonthlyForumReportReq toRequest(Map<String, Object> payload) {
        return MakeMonthlyForumReportReq.create(
                (int) payload.get("month"),
                (int) payload.get("year")
        );
    }

    public MakeMonthlyForumReportRes toResponse(String report) {
        return new MakeMonthlyForumReportRes(
            report
        );
    }

}
