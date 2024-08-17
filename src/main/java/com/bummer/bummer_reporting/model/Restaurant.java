package com.bummer.bummer_reporting.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "email_2")
    private String email2;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "phone_number_2")
    private String phoneNumber2;

    private String website;
    private String hours;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;  // Assuming there is a User class representing the Users table

    private String cuisine;
    private Boolean takeaway;
    private String serviceType;
    private String priceRange;
    private Boolean delivery;
    private Boolean reservation;
    private Boolean outdoorSeating;
    private Boolean wifi;
    private String payment;
    private String accessibility;
    private Boolean parking;
    private String specialities;
    private String ambiance;
    private String bestForCrowd;

    @Column(name = "created_at", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    //Relationships
    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Address address;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Crowdmeter> crowdmeters;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Menu> menus;
}
