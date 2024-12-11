package com.twopiradrian.report_ms.config.helper;

import com.twopiradrian.report_ms.domain.models.Forum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReportHelper {

    @Value("${report.template}")
    private String reportTemplate;

    public String readReportTemplate(Forum forum) {
        // template: "{The forum {forumId} was created by {userId} at {createdAt}, and has {views} views}"
        return this.reportTemplate
                .replace("{forumId}", String.valueOf(forum.getId()))
                .replace("{userId}", String.valueOf(forum.getAuthor().getId()))
                .replace("{createdAt}", String.valueOf(forum.getCreatedAt()))
                .replace("{views}", String.valueOf(forum.getViews()));

    }


}
