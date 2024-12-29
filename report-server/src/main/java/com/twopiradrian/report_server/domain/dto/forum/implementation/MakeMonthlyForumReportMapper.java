package com.twopiradrian.report_server.domain.dto.forum.implementation;

import com.twopiradrian.report_server.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.report_server.domain.dto.forum.response.MakeMonthlyForumReportRes;

import java.util.Map;

public class MakeMonthlyForumReportMapper {

    public MakeMonthlyForumReportReq toRequest(Map<String, Object> payload) {
        return MakeMonthlyForumReportReq.create(
                (Integer) payload.get("month"),
                (Integer) payload.get("year")
        );
    }

    public MakeMonthlyForumReportRes toResponse(String report) {
        return new MakeMonthlyForumReportRes(
            report
        );
    }

}
