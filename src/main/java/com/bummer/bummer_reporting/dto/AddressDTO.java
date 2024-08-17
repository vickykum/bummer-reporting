package com.bummer.bummer_reporting.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String housenumber;
    private String street;
    private String unit;
    private String floor;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private Double latitude;
    private Double longitude;
}
