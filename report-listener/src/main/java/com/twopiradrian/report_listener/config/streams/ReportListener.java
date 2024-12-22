package com.twopiradrian.report_listener.config.streams;

import com.twopiradrian.report_listener.domain.entity.Report;
import com.twopiradrian.report_listener.presentation.service.ReportServiceI;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@AllArgsConstructor
public class ReportListener {

    private final ReportServiceI reportService;

    @Bean
    public Consumer<String> reportConsumer() {
        return reportContent -> {
            Report report = new Report();
            report.setContent(reportContent);

            this.reportService.saveReport(report);
        };
    }

}
