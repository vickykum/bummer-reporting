package com.bummer.bummer_reporting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @GetMapping
    public String getAllRestaurants() {
        return "List of all restaurants";
    }
}
