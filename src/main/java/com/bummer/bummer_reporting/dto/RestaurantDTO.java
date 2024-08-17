package com.bummer.bummer_reporting.dto;

import lombok.Data;
import java.util.List;

@Data
public class RestaurantDTO {
    private Long id;
    private String name;
    private String email;
    private String email2;
    private String phoneNumber;
    private String phoneNumber2;
    private String website;
    private String hours;
    private String owner;
    private String cuisine;
    private Boolean takeaway;
    private String serviceType;
    private String priceRange;
    private List<String> menu;
    private Boolean delivery;
    private Boolean reservation;
    private Boolean outdoorSeating;
    private Boolean wifi;
    private List<String> payment;
    private List<String> accessibility;
    private Boolean parking;
    private List<String> specialities;
    private String ambiance;
    private String bestForCrowd;

    // Additional fields for aggregated data
    private AddressDTO address;
    private List<ReviewDTO> reviews;
    private List<MenuDTO> menuItems;
    private List<ReportsDTO> reports;
    private List<ReviewDTO> reviewsData;
    private List<CrowdMeterDTO> crowdMeter;
}
