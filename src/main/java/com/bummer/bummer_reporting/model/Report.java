package com.bummer.bummer_reporting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    @OneToOne(mappedBy = "report")
    @JsonIgnore
    private Review review;

    @Column(name = "report_star")
    private Integer reportStar;

    @Column(name = "report_type")
    private String reportType;

    @Column(name = "total_reports")
    private Integer totalReports;

    @Column(name = "today_reports")
    private Integer todayReports;

    @Column(name = "last_week_reports")
    private Integer lastWeekReports;

    @Column(name = "last_month_reports")
    private Integer lastMonthReports;

    @Column(name = "reporting_timestamp")
    private LocalDateTime reportingTimestamp;
}
