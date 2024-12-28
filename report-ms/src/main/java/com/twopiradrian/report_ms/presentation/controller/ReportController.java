package com.twopiradrian.report_ms.presentation.controller;

import com.twopiradrian.report_ms.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.report_ms.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.report_ms.domain.error.ErrorHandler;
import com.twopiradrian.report_ms.domain.error.ErrorType;
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
        try {
            MakeMonthlyForumReportReq dto = ForumMapper.makeMonthlyReport().toRequest(payload);

            return ResponseEntity.ok(this.reportService.makeMonthlyForumReport(dto));
        }
        catch (ErrorHandler e) {
            return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(ErrorType.INTERNAL_ERROR.getMessage());
        }
    }

}
