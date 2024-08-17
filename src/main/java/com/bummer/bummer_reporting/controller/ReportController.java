package com.bummer.bummer_reporting.controller;

import com.bummer.bummer_reporting.model.Report;
import com.bummer.bummer_reporting.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // Get all reports for a specific restaurant
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Report>> getReportsByRestaurantId(@PathVariable Long restaurantId) {
        List<Report> reports = reportService.getReportsByRestaurantId(restaurantId);
        return new ResponseEntity<>(reports, HttpStatus.OK);
    }

    // Get a specific report by ID
    @GetMapping("/{reportId}")
    public ResponseEntity<Report> getReportById(@PathVariable Long reportId) {
        Optional<Report> report = reportService.getReportById(reportId);
        return report.map(r -> new ResponseEntity<>(r, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new report
    @PostMapping
    public ResponseEntity<Report> createReport(@RequestBody Report report) {
        Report savedReport = reportService.createReport(report);
        return new ResponseEntity<>(savedReport, HttpStatus.CREATED);
    }

    // Update an existing report
    @PutMapping("/{reportId}")
    public ResponseEntity<Report> updateReport(@PathVariable Long reportId, @RequestBody Report updatedReport) {
        Report savedReport = reportService.updateReport(reportId, updatedReport);
        if (savedReport != null) {
            return new ResponseEntity<>(savedReport, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a report
    @DeleteMapping("/{reportId}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long reportId) {
        reportService.deleteReport(reportId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
