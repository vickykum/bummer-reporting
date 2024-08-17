package com.bummer.bummer_reporting.controller;

import com.bummer.bummer_reporting.model.Address;
import com.bummer.bummer_reporting.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.getAddressById(id);
    }

    // Get address by latitude and longitude
    @GetMapping("/by-lat-lon")
    public List<Address> getAddressesByLatLon(
            @RequestParam("latitude") Double latitude,
            @RequestParam("longitude") Double longitude) {
        return addressService.getAddressesByLatLon(latitude, longitude);
    }

    // Get address by city and state
    @GetMapping("/by-city-state")
    public List<Address> getAddressesByCityAndState(
            @RequestParam("city") String city,
            @RequestParam("state") String state) {
        return addressService.getAddressesByCityAndState(city, state);
    }

    // Get address by postal code
    @GetMapping("/by-postcode")
    public List<Address> getAddressesByPostcode(
            @RequestParam("postcode") String postcode) {
        return addressService.getAddressesByPostcode(postcode);
    }

    // Get address by city, state, and country
    @GetMapping("/by-city-state-country")
    public List<Address> getAddressesByCityStateCountry(
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("country") String country) {
        return addressService.getAddressesByCityAndStateAnsCountry(city, state, country);
    }

    // Get address by restaurant ID
    @GetMapping("/by-restaurant-id")
    public Address getAddressByRestaurantId(
            @RequestParam("restaurantId") Long restaurantId) {
        return addressService.getAddressByRestaurantId(restaurantId);
    }
}
