package com.twopiradrian.report_ms.presentation.controller;

import com.twopiradrian.report_ms.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.report_ms.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import com.twopiradrian.report_ms.presentation.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/reports")
public class ReportController {

    private ReportService reportService;

    @PostMapping
    public ResponseEntity<?> makeMonthlyForumReport(@RequestBody Map<String, Object> payload) {
        MakeMonthlyForumReportReq dto = ForumMapper.makeMonthlyReport().toRequest(payload);

        return ResponseEntity.ok(this.reportService.makeMonthlyForumReport(dto));
    }

}
