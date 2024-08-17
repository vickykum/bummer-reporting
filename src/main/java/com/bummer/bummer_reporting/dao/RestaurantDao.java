package com.bummer.bummer_reporting.dao;

import com.bummer.bummer_reporting.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Long> {

    // Find by name
    List<Restaurant> findByName(String name);

    // Find by cuisine
    List<Restaurant> findByCuisine(String cuisine);

    // Find by delivery option
    List<Restaurant> findByDelivery(Boolean delivery);
//
//    // Find by city
//    List<Restaurant> findByCity(String city);
//
//    // Find by state
//    List<Restaurant> findByState(String state);

    // Find by price range
    List<Restaurant> findByPriceRange(String priceRange);

    // Find by combination of city and state
//    List<Restaurant> findByCityAndState(String city, String state);

    // Find by owner ID
    List<Restaurant> findByOwnerId(Long ownerId);

    // Find by combination of amenities (e.g., outdoor seating and wifi)
    List<Restaurant> findByOutdoorSeatingAndWifi(Boolean outdoorSeating, Boolean wifi);
}
