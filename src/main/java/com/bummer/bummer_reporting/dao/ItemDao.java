package com.bummer.bummer_reporting.dao;

import com.bummer.bummer_reporting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<Item, Long> {
    // Additional query methods can be defined here if needed
}
