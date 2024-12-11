package com.twopiradrian.report_ms.domain.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReportHelper {

    @Value("${report.template}")
    private String reportTemplate;

    public String getReportTemplate() {
        System.out.println(reportTemplate);

        return reportTemplate;
    }


}
