package com.twopiradrian.report_server.presentation.controller;

import com.twopiradrian.report_server.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.report_server.domain.dto.forum.request.MakeMonthlyForumReportReq;
import com.twopiradrian.report_server.presentation.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/reports")
public class ReportController {

    private ReportService reportService;

    @GetMapping("/forums/monthly")
    public ResponseEntity<?> makeMonthlyForumReport(
            @RequestHeader(value = "Authorization") String token,
            @RequestHeader(value = "month") Integer month,
            @RequestHeader(value = "year") Integer year
    ) {
        MakeMonthlyForumReportReq dto = ForumMapper.makeMonthlyReport().toRequest(token, month, year);

        return ResponseEntity.ok(this.reportService.makeMonthlyForumReport(dto));
    }

}
