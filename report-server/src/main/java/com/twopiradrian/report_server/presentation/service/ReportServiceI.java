package com.twopiradrian.report_server.presentation.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twopiradrian.entity.Category;
import com.twopiradrian.entity.Forum;
import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import com.twopiradrian.report_server.config.streams.ReportPublisher;
import com.twopiradrian.report_server.data.repository.ForumRepositoryI;
import com.twopiradrian.report_server.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.report_server.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.report_server.domain.dto.forum.response.MakeMonthlyForumReportRes;
import com.twopiradrian.report_server.domain.reports.ReportType;
import com.twopiradrian.report_server.domain.reports.forum.MonthlyForums;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReportServiceI implements ReportService {

    private final ForumRepositoryI forumRepository;

    private final ReportPublisher reportPublisher;

    private final ObjectMapper objectMapper;

    @Override
    public MakeMonthlyForumReportRes makeMonthlyForumReport(MakeMonthlyForumReportReq dto) {
        var forums = this.forumRepository.getMonthlyForums(dto.getToken(), dto.getMonth(), dto.getYear());

        if (forums == null || forums.isEmpty()) {
            throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);
        }

        MonthlyForums report = new MonthlyForums();
        report.setMonth(dto.getMonth());
        report.setYear(dto.getYear());

        Integer totalForums = forums.size();
        report.setTotalForums(totalForums);

        Map<Category, Integer> forumsByCategory = forums.stream()
                .collect(Collectors.groupingBy(Forum::getCategory, Collectors.summingInt(forum -> 1)));
        report.setForumsByCategory(forumsByCategory);

        Map<Category, Integer> viewsByCategory = forums.stream()
                .collect(Collectors.groupingBy(Forum::getCategory, Collectors.summingInt(Forum::getViews)));
        report.setViewsByCategory(viewsByCategory);

        report.setType(ReportType.FORUM_MONTHLY_REPORT);

        String reportJson;
        try {
            reportJson = objectMapper.writeValueAsString(report);
        }
        catch (Exception e) {
            throw new ErrorHandler(ErrorType.INTERNAL_ERROR);
        }

        this.reportPublisher.publishReport(reportJson);

        return ForumMapper.makeMonthlyReport().toResponse(report);
    }

}
