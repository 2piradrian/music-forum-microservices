package com.twopiradrian.report_ms.presentation.controller;

import com.twopiradrian.report_ms.presentation.service.ReportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "report")
@AllArgsConstructor
public class ReportController {

    private ReportService reportService;

    @GetMapping(path = "{forumId}")
    public ResponseEntity<Map<String, String>> makeReport(@PathVariable Long forumId) {
        var response = Map.of("report", this.reportService.makeReport(forumId));

        return ResponseEntity.ok(response);
    }

}
