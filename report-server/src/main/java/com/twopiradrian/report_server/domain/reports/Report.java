package com.twopiradrian.report_server.domain.reports;

import lombok.Data;

@Data
public abstract class Report {

    private ReportType type;

}
