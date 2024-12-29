package com.twopiradrian.report_server.config.streams;

import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ReportPublisher {

    private final StreamBridge streamBridge;

    public void publishReport(String report) {
        this.streamBridge.send("consumer-report", report);
        this.streamBridge.send("consumer-report-in-0", report);
        this.streamBridge.send("consumer-report-out-0", report);
    }
}
