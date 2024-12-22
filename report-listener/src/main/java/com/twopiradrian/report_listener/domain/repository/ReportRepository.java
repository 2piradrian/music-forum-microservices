package com.twopiradrian.report_listener.domain.repository;

import com.twopiradrian.report_listener.domain.entity.Report;

public interface ReportRepository {

    void saveReport(Report report);

}
