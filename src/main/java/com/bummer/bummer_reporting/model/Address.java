package com.bummer.bummer_reporting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "restaurant_id", unique = true)
    @JsonIgnore
    private Restaurant restaurant;

    @Column(name = "housenumber")
    private String houseNumber;

    @Column(name = "street")
    private String street;

    @Column(name = "unit")
    private String unit;

    @Column(name = "floor")
    private String floor;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postcode")
    private String postcode;

    @Column(name = "country")
    private String country;

    @Column(name = "lat")
    private Double latitude; // Use Double for precision

    @Column(name = "lon")
    private Double longitude; // Use Double for precision
}
