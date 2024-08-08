package com.bummer.bummer_reporting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @GetMapping
    public String getAllReviews() {
        return "List of all reviews";
    }
}
