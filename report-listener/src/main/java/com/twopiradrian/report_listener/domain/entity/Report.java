package com.twopiradrian.report_listener.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    private String id;

    private LocalDateTime date;

    private String type;

    private String content;

}
