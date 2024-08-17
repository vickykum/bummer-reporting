package com.bummer.bummer_reporting.service;

import com.bummer.bummer_reporting.model.Report;
import com.bummer.bummer_reporting.dao.ReportDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportDao reportDao;

    public Report createReport(Report report) {
        return reportDao.save(report);
    }

    public Optional<Report> getReportById(Long id) {
        return reportDao.findById(id);
    }

    public List<Report> getAllReports() {
        return reportDao.findAll();
    }

    public Report updateReport(Long id, Report reportDetails) {
        return reportDao.findById(id)
                .map(report -> {
                    report.setReportStar(reportDetails.getReportStar());
                    report.setReportType(reportDetails.getReportType());
                    report.setTotalReports(reportDetails.getTotalReports());
                    report.setTodayReports(reportDetails.getTodayReports());
                    report.setLastWeekReports(reportDetails.getLastWeekReports());
                    report.setLastMonthReports(reportDetails.getLastMonthReports());
                    report.setReportingTimestamp(reportDetails.getReportingTimestamp());
                    return reportDao.save(report);
                })
                .orElseGet(() -> {
                    reportDetails.setId(id);
                    return reportDao.save(reportDetails);
                });
    }

    public void deleteReport(Long id) {
        reportDao.deleteById(id);
    }

    public List<Report> getReportsByRestaurantId(Long restaurantId) {
        return reportDao.findByRestaurantId(restaurantId);
    }
}
