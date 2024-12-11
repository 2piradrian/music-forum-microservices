package com.twopiradrian.report_ms.presentation.service;

public interface ReportService {

    String makeReport(Long id);

    String saveReport(String reportName);

    void deleteReport(String reportName);

}
