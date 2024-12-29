package com.twopiradrian.report_server.presentation.service;

import com.twopiradrian.entity.Forum;
import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import com.twopiradrian.report_server.config.helper.ReportHelper;
import com.twopiradrian.report_server.config.streams.ReportPublisher;
import com.twopiradrian.report_server.data.repository.ForumRepositoryI;
import com.twopiradrian.report_server.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.report_server.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.report_server.domain.dto.forum.response.MakeMonthlyForumReportRes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ReportServiceI implements ReportService {

    private final ForumRepositoryI forumRepository;

    private final ReportHelper reportHelper;
    private final ReportPublisher reportPublisher;

    @Override
    public MakeMonthlyForumReportRes makeMonthlyForumReport(MakeMonthlyForumReportReq dto) {
        var forums = this.forumRepository.getMonthlyForums(dto.getMonth(), dto.getYear());

        if (forums == null || forums.isEmpty()) {
            throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);
        }

        // TODO: Implement the logic to generate the report from the list of forums
        String report = reportHelper.readReportTemplate(new Forum());

        this.reportPublisher.publishReport(report);

        return ForumMapper.makeMonthlyReport().toResponse(report);
    }

}
