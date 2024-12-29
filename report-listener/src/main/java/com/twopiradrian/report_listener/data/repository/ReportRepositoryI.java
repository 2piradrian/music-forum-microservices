package com.twopiradrian.report_listener.data.repository;

import com.twopiradrian.report_listener.data.mongo.mapper.ReportEntityMapper;
import com.twopiradrian.report_listener.data.mongo.model.ReportModel;
import com.twopiradrian.report_listener.data.mongo.repository.MongoReportRepository;
import com.twopiradrian.report_listener.domain.entity.Report;
import com.twopiradrian.report_listener.domain.repository.ReportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ReportRepositoryI implements ReportRepository {

    private final MongoReportRepository reportRepository;

    @Override
    public void save(Report report) {
        ReportModel reportModel = ReportEntityMapper.toModel(report);
        this.reportRepository.save(reportModel);
    }

}
