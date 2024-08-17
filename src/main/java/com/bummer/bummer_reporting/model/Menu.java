package com.bummer.bummer_reporting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    @Column(name = "items", columnDefinition = "TEXT")
    private String items; // Stored as CSV or JSON format

    @Column(name = "menu_link")
    private String menuLink;

    @Column(name = "timestamp", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timestamp;

    @Column(name = "menu_type")
    private String menuType; // 'drinks', 'food', 'dessert', 'all'
}
