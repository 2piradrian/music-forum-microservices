package com.twopiradrian.report_ms.presentation.service;

import com.twopiradrian.report_ms.data.repository.ForumRepository;
import com.twopiradrian.report_ms.config.helper.ReportHelper;
import com.twopiradrian.report_ms.domain.models.Category;
import com.twopiradrian.report_ms.domain.models.Forum;
import com.twopiradrian.report_ms.domain.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

}
