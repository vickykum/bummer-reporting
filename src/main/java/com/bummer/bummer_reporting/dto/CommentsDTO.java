package com.bummer.bummer_reporting.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class CommentsDTO {
    private Long id;
    private Long reviewId;
    private Long restaurantId;
    private Integer replyLevel;
    private String reviewReplyBlob;
    private Integer upvotes;
    private Integer downvotes;
    private Long parentReviewId;
    private Timestamp timestamp;
    private List<String> reviewKeywords;
    private List<CommentsDTO> parentReview;

    // Getters and setters
}
