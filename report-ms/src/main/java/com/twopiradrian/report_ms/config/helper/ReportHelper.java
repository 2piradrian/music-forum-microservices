package com.twopiradrian.report_ms.config.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReportHelper {

    @Value("${report.template}")
    private String reportTemplate;

    public String getReportTemplate() {
        return reportTemplate;
    }


}
