package com.twopiradrian.report_ms.presentation.service;

import com.twopiradrian.report_ms.data.repository.ForumRepository;
import com.twopiradrian.report_ms.config.helper.ReportHelper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReportServiceI implements ReportService {

    private final ForumRepository forumRepository;
    private final ReportHelper reportHelper;

    @Override
    public String makeReport(Long id) {
        reportHelper.getReportTemplate();
        return this.forumRepository.getForumById(id).orElseThrow().getTitle();
    }

    @Override
    public String saveReport(String reportName) {
        return "";
    }

    @Override
    public void deleteReport(String reportName) {

    }

}
