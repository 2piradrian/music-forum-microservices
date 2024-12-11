package com.twopiradrian.report_ms.presentation.service;

import com.twopiradrian.report_ms.data.repository.ForumRepository;
import com.twopiradrian.report_ms.config.helper.ReportHelper;
import com.twopiradrian.report_ms.domain.models.Forum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReportServiceI implements ReportService {

    private final ForumRepository forumRepository;
    private final ReportHelper reportHelper;

    @Override
    public String makeReport(Long id) {
        var forumFromDB = this.forumRepository.getForumById(id).orElseThrow();

        Forum forum = new Forum();
        forum.setId(forumFromDB.getForumId());
        forum.setAuthor(forumFromDB.getAuthor());
        forum.setTitle(forumFromDB.getTitle());
        forum.setContent(forumFromDB.getContent());
        forum.setViews(forumFromDB.getViews());
        forum.setCategory(forumFromDB.getCategory());
        forum.setComments(forumFromDB.getComments());
        forum.setCreatedAt(forumFromDB.getCreatedAt());

        return reportHelper.readReportTemplate(forum);
    }

    @Override
    public String saveReport(String reportName) {
        return "";
    }

    @Override
    public void deleteReport(String reportName) {

    }

}
