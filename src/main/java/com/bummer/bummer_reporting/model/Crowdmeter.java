package com.bummer.bummer_reporting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Crowdmeter")
public class Crowdmeter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    private Integer currentCrowd;
    private Integer waitingTimeMinutes;

    @Column(name = "reporting_timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime reportingTimestamp;

    @PrePersist
    protected void onCreate() {
        this.reportingTimestamp = LocalDateTime.now();
    }
}
