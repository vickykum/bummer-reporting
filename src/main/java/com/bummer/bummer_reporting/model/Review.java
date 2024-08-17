package com.bummer.bummer_reporting.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    @Column(name = "review_blob", columnDefinition = "TEXT")
    private String reviewBlob;

    @Column(name = "upvotes")
    private Integer upvotes;

    @Column(name = "downvotes")
    private Integer downvotes;

    @OneToOne
    @JoinColumn(name = "report_id", referencedColumnName = "id", nullable = false)
    private Report report;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "review_keywords")
    private String reviewKeywords; // Stored as CSV or JSON

    @Column(name = "reporting_timestamp")
    private LocalDateTime reportingTimestamp;

    @Column(name = "total_comments")
    private Integer totalComments;
}
