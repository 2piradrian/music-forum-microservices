package com.twopiradrian.report_listener.presentation.service;

import com.twopiradrian.report_listener.data.repository.ReportRepositoryI;
import com.twopiradrian.report_listener.domain.entity.Report;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class ReportServiceI implements ReportService {

    private final ReportRepositoryI reportRepository;

    @Override
    public void saveReport(Report report) {
        this.reportRepository.save(report);
    }

}
