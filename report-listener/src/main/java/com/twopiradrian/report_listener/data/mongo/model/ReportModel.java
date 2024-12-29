package com.twopiradrian.report_listener.data.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class ReportModel {

    @Id
    private String id;

    private LocalDateTime date;

    private String type;

    private String content;

}
