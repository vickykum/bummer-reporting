package com.bummer.bummer_reporting.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CrowdMeterDTO {
    private Long id;
    private Long restaurantId;
    private Integer currentCrowd;
    private Integer waitingTimeMinutes;
    private Timestamp reportingTimestamp;

    // Getters and setters
}
