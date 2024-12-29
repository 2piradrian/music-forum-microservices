package com.twopiradrian.report_listener.config.streams;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twopiradrian.report_listener.domain.entity.Report;
import com.twopiradrian.report_listener.presentation.service.ReportServiceI;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.function.Consumer;

@Slf4j
@Configuration
@AllArgsConstructor
public class ReportListener {

    private final ReportServiceI reportService;

    private final ObjectMapper objectMapper;

    @Bean
    public Consumer<String> reportConsumer() {
        return reportContent -> {
            try {
                Report report = new Report();

                String type = objectMapper.readTree(reportContent).get("type").asText();

                report.setContent(reportContent);
                report.setType(type);
                report.setDate(LocalDateTime.now());

                this.reportService.saveReport(report);
            }
            catch (Exception e) {
                log.error(e.getMessage());
            }
        };
    }

}
