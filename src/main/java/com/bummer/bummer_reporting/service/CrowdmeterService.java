package com.bummer.bummer_reporting.service;

import com.bummer.bummer_reporting.dao.CrowdmeterDao;
import com.bummer.bummer_reporting.model.Crowdmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CrowdmeterService {

    @Autowired
    private CrowdmeterDao crowdmeterDao;

    public Crowdmeter createCrowdmeter(Crowdmeter crowdmeter) {
        return crowdmeterDao.save(crowdmeter);
    }

    public Optional<Crowdmeter> getCrowdmeterById(Long id) {
        return crowdmeterDao.findById(id);
    }

    public List<Crowdmeter> getCrowdmeterByRestaurantId(Long restaurantId) {
        return crowdmeterDao.findByRestaurantId(restaurantId);
    }

    public List<Crowdmeter> getCrowdmeterByReportingTimestamp(LocalDateTime start, LocalDateTime end) {
        return crowdmeterDao.findByReportingTimestampBetween(start, end);
    }

    public Crowdmeter updateCrowdmeter(Long id, Crowdmeter crowdmeterDetails) {
        return crowdmeterDao.findById(id)
                .map(crowdmeter -> {
                    crowdmeter.setCurrentCrowd(crowdmeterDetails.getCurrentCrowd());
                    crowdmeter.setWaitingTimeMinutes(crowdmeterDetails.getWaitingTimeMinutes());
                    crowdmeter.setReportingTimestamp(crowdmeterDetails.getReportingTimestamp());
                    return crowdmeterDao.save(crowdmeter);
                })
                .orElseGet(() -> {
                    crowdmeterDetails.setId(id);
                    return crowdmeterDao.save(crowdmeterDetails);
                });
    }

    public void deleteCrowdmeter(Long id) {
        crowdmeterDao.deleteById(id);
    }
}
