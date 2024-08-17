package com.bummer.bummer_reporting.service;

import com.bummer.bummer_reporting.dao.RestaurantDao;
import com.bummer.bummer_reporting.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantDao restaurantDao;

    public List<Restaurant> getAllRestaurants() {
        return restaurantDao.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantDao.findById(id).orElse(null);
    }

    public List<Restaurant> getRestaurantsByName(String name) {
        return restaurantDao.findByName(name);
    }

    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
        return restaurantDao.findByCuisine(cuisine);
    }
//
//    public List<Restaurant> getRestaurantsByCityAndState(String city, String state) {
//        return restaurantDao.findByCityAndState(city, state);
//    }

    public List<Restaurant> getRestaurantsByAmenities(Boolean outdoorSeating, Boolean wifi) {
        return restaurantDao.findByOutdoorSeatingAndWifi(outdoorSeating, wifi);
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantDao.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) {
        Optional<Restaurant> optionalRestaurant = restaurantDao.findById(id);

        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();

            restaurant.setName(restaurantDetails.getName());
            restaurant.setEmail(restaurantDetails.getEmail());
            restaurant.setEmail2(restaurantDetails.getEmail2());
            restaurant.setPhoneNumber(restaurantDetails.getPhoneNumber());
            restaurant.setPhoneNumber2(restaurantDetails.getPhoneNumber2());
            restaurant.setWebsite(restaurantDetails.getWebsite());
            restaurant.setHours(restaurantDetails.getHours());
            restaurant.setOwner(restaurantDetails.getOwner());
            restaurant.setCuisine(restaurantDetails.getCuisine());
            restaurant.setTakeaway(restaurantDetails.getTakeaway());
            restaurant.setServiceType(restaurantDetails.getServiceType());
            restaurant.setPriceRange(restaurantDetails.getPriceRange());
            restaurant.setDelivery(restaurantDetails.getDelivery());
            restaurant.setReservation(restaurantDetails.getReservation());
            restaurant.setOutdoorSeating(restaurantDetails.getOutdoorSeating());
            restaurant.setWifi(restaurantDetails.getWifi());
            restaurant.setPayment(restaurantDetails.getPayment());
            restaurant.setAccessibility(restaurantDetails.getAccessibility());
            restaurant.setParking(restaurantDetails.getParking());
            restaurant.setSpecialities(restaurantDetails.getSpecialities());
            restaurant.setAmbiance(restaurantDetails.getAmbiance());
            restaurant.setBestForCrowd(restaurantDetails.getBestForCrowd());

            // Save the updated restaurant object to the database
            return restaurantDao.save(restaurant);
        } else {
            // Handle the case when the restaurant with the given id is not found
            throw new RuntimeException("Restaurant not found with id " + id);
        }
    }
}
