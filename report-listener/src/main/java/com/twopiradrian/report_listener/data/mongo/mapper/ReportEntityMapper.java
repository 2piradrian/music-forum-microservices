package com.twopiradrian.report_listener.data.mongo.mapper;

import com.twopiradrian.report_listener.data.mongo.model.ReportModel;
import com.twopiradrian.report_listener.domain.entity.Report;

public class ReportEntityMapper {

    public static Report toDomain(ReportModel reportModel) {
        return new Report(
            reportModel.getId(),
            reportModel.getContent()
        );
    }

    public static ReportModel toModel(Report report) {
        return new ReportModel(
            report.getId(),
            report.getContent()
        );
    }

}
