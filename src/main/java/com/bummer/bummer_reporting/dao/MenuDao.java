package com.bummer.bummer_reporting.dao;

import com.bummer.bummer_reporting.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDao extends JpaRepository<Menu, Long> {
    // Additional query methods can be defined here if needed
}
