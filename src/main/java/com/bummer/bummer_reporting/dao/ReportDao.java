package com.bummer.bummer_reporting.dao;

import com.bummer.bummer_reporting.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDao extends JpaRepository<Report, Long> {

    // Find all reports by restaurant ID
    List<Report> findByRestaurantId(Long restaurantId);

    // Find reports by type and restaurant ID
    List<Report> findByReportTypeAndRestaurantId(String reportType, Long restaurantId);

    // Additional custom queries can be added here
}
