package com.bummer.bummer_reporting.dao;

import com.bummer.bummer_reporting.model.Crowdmeter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CrowdmeterDao extends JpaRepository<Crowdmeter, Long> {

    List<Crowdmeter> findByRestaurantId(Long restaurantId);

    List<Crowdmeter> findByReportingTimestampBetween(LocalDateTime start, LocalDateTime end);
}
