package com.bummer.bummer_reporting.dao;

import com.bummer.bummer_reporting.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao extends JpaRepository<Address, Long> {

    // Find by latitude and longitude
    List<Address> findByLatitudeAndLongitude(Double latitude, Double longitude);

    // Find by city and state
    List<Address> findByCityAndState(String city, String state);

    // Find by postal code
    List<Address> findByPostcode(String postcode);

    // Find by a combination of city, state, and country
    List<Address> findByCityAndStateAndCountry(String city, String state, String country);

    // Find by restaurant ID
    Address findByRestaurantId(Long restaurantId);
}
