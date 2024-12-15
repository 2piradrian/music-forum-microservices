package com.twopiradrian.report_ms.presentation.service;

import com.twopiradrian.report_ms.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.report_ms.domain.dto.forum.response.MakeMonthlyForumReportRes;

public interface ReportService {

    MakeMonthlyForumReportRes makeMonthlyForumReport(MakeMonthlyForumReportReq dto);

}
