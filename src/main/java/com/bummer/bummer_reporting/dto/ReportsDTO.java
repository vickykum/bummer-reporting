package com.bummer.bummer_reporting.dto;

import lombok.Data;

@Data
public class ReportsDTO {
    private Long id;
    private Integer reportType;
    private Integer totalReports;
    private Integer todayReports;
    private Integer lastWeekReports;
    private Integer lastMonthReports;
    private String reportTypeDesc;
}
