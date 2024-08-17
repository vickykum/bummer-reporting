package com.bummer.bummer_reporting.controller;

import com.bummer.bummer_reporting.model.Restaurant;
import com.bummer.bummer_reporting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(restaurantService.createRestaurant(restaurant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        return ResponseEntity.ok(restaurantService.updateRestaurant(id, restaurant));
    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
//        restaurantService.deleteRestaurant(id);
//        return ResponseEntity.noContent().build();
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<List<Restaurant>> searchRestaurants(@RequestParam(required = false) String housenumber,
//                                                                 @RequestParam(required = false) String street,
//                                                                 @RequestParam(required = false) String unit,
//                                                                 @RequestParam(required = false) String city,
//                                                                 @RequestParam(required = false) String state,
//                                                                 @RequestParam(required = false) String country) {
//        return ResponseEntity.ok(restaurantService.searchRestaurants(housenumber, street, unit, city, state, country));
//    }
}
