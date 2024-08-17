package com.bummer.bummer_reporting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "cuisine")
    private String cuisine;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "imagelink")
    private String imageLink;

    @Column(name = "svg")
    private String svg;

    @Column(name = "timestamp", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timestamp;
}
